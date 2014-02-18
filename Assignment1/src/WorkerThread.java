import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


public class WorkerThread extends Thread {

	Socket clientSocket;
	
	public WorkerThread(Socket cs) {
		this.clientSocket = cs;
	}
	
	public void run() {
		try {
			BufferedReader r = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String line;
			PrintStream ps = new PrintStream(clientSocket.getOutputStream());
			while((line = r.readLine()) != null) {
				ps.println(line.toUpperCase());
			}
			
			ps.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
