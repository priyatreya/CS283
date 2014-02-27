package bananabank.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class simpleBBClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket s = new Socket("localhost", 5554);
		PrintStream ps = new PrintStream(s.getOutputStream());
		ps.println("50 11111 88888");
		String line;
		BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
		line = r.readLine();
		System.out.println(line);
		
		ps.println("50 22222 77777");
		line = r.readLine();
		System.out.println(line);
		
		ps.println("shutdown");
		line = r.readLine();
		System.out.println(line);
		
		System.out.println("client done");

	}

}
