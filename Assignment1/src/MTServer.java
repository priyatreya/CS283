import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class MTServer {

	/**
	 * @param args
	 * @throws IOException 
	 */

	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(4443);
		
		for(;;) {
			Socket cs = ss.accept();
			new WorkerThread(cs).start();
		}
		

	}

}
