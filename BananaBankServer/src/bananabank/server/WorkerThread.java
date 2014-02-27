package bananabank.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;



public class WorkerThread extends Thread {

	Socket clientSocket;
	ServerSocket serverSocket;
	BananaBank bank;
	ArrayList<WorkerThread> threadLst;
	
	public WorkerThread(Socket cs, ServerSocket ss, BananaBank bb, ArrayList<WorkerThread> threads) {
		this.clientSocket = cs;
		this.serverSocket = ss;
		this.bank = bb;
		this.threadLst = threads;
	}
	
	public void run() {
		try {
			BufferedReader r = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String line;
			boolean shutdown = false;
			PrintStream ps = new PrintStream(clientSocket.getOutputStream());
			
			while((line = r.readLine()) != null && shutdown == false) {
				if(!line.equalsIgnoreCase("shutdown")){
					StringTokenizer st = new StringTokenizer(line);
					int amount = Integer.parseInt(st.nextToken());
					int src = Integer.parseInt(st.nextToken());
					int dst = Integer.parseInt(st.nextToken());

					if(bank.getAccount(src) == null) {
						ps.println("Invalid source account " + src);
					}
					else if(bank.getAccount(dst) == null) {
						ps.println("Invalid destination account " + dst);
					}
					else {
						synchronized(bank.getAccount(Math.min(src, dst))) {
							synchronized(bank.getAccount(Math.max(src, dst))) {
								bank.getAccount(src).transferTo(amount, bank.getAccount(dst));
							}
						}
						ps.println(amount + " transferred from account " + src + " to " + dst);
					}
				}
				else {
					serverSocket.close();					
					WorkerThread t;
					Iterator<WorkerThread> itr1 = threadLst.iterator();
					while(itr1.hasNext()) {
						t = itr1.next();
						if(t != Thread.currentThread()) {
							t.join();
						}
					}
					
					bank.save("accounts.txt");
					int sum = 0;
					Iterator<Account> itr2 = bank.getAllAccounts().iterator();
					while(itr2.hasNext()) {
						sum += itr2.next().getBalance();
					}
					ps.println(Integer.toString(sum) + "\n");
					shutdown = true;
					System.out.println("WorkerThread: shutdown complete");
				}
			}
			
			ps.close();
		}
		catch(IOException | InterruptedException e) {}
	}
	
	

}
