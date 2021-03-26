package ht;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Kliens {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		int port = 1500;
		String server = "localhost";
		Socket so = null;

		// server informations
		if (args.length == 2) {
			server = args[0];
			try {
				port = Integer.parseInt(args[1]);
			} catch (Exception e) {
				System.out.println("server port = 1500 (default)");
				port = 1500;
			}
		}

		// connect to server
		try {
			so = new Socket(server, port);
		} catch (UnknownHostException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		
		BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));		
		PrintWriter pw = new PrintWriter(so.getOutputStream());
		
		String line = bf.readLine();
		pw.println(line);
		System.out.println("Az elküldött üzenet: " + line);
		
		pw.flush();
		
		bf.close();
		pw.close();
	
	}

}
