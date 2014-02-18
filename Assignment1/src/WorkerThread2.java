import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class WorkerThread2 extends Thread{

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public  void run() {
		
		int port = 4443;
		long start = System.currentTimeMillis();
		long end = start + 1000;
		PrintStream ps = null;
		Socket s = null;
		
		while(System.currentTimeMillis() < end) {

			try {
				s = new Socket("localhost", port);
				ps = new PrintStream(s.getOutputStream());
				BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String line;
				
				ps.println("Hello world!!");
				line = r.readLine();
	//			System.out.println(line);
				Thread.sleep(10);
				System.out.println("1 ");
			
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ps.close();

		}
		
		


	}

}
