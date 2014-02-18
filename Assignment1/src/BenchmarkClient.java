import java.io.IOException;
//import java.net.Socket;
import java.net.UnknownHostException;


public class BenchmarkClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args)  {
		System.out.println("client start");
		
		for(int i = 0; i < 5; i++) {
			new WorkerThread2().start();
		}
		
		System.out.println("main program done");

	}

}
