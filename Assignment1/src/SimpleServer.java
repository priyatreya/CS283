import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class SimpleServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(3334);
		while(true) {
			Socket cs = ss.accept();
			BufferedReader r = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			String line;
			PrintStream ps = new PrintStream(cs.getOutputStream());
			while((line = r.readLine()) != null) {
				ps.println(line.toUpperCase());
			}
			
			
			ps.close();
			
		}
		
		
	}

}
