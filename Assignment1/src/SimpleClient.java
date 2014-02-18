import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class SimpleClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket s = new Socket("localhost", 4444);
		PrintStream ps = new PrintStream(s.getOutputStream());
		ps.println("Hello world!!");
		
		String line;
		BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
		line = r.readLine();
		System.out.println(line.toUpperCase());
		
		
		
		ps.close();
		s.close();
		System.out.println("client done");
	}

}
