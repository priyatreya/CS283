package bananabank.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;



public class MTServer {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */

	public static void main(String[] args) throws IOException, InterruptedException {
		
		BananaBank bank = new BananaBank("accounts.txt");
		ServerSocket ss = new ServerSocket(5554);
		ArrayList<WorkerThread> threads = new ArrayList<WorkerThread>();
		
		try {
			for(;;) {
				Socket cs = ss.accept();
				WorkerThread t = new WorkerThread(cs, ss, bank, threads);
				t.start();
				threads.add(t);
			}
		} catch(SocketException e) {
			System.out.println("Server: serverSocket closed");
		}
		
		System.out.println("server done");

	}

}
