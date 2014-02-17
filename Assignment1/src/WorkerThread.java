import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
			while((line = r.readLine()) != null) {
				System.out.println(line.toUpperCase());
			}
			
			r.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
