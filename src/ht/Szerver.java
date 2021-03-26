package ht;

import java.io.IOException;
import java.net.ServerSocket;

public class Szerver {

	public static void main(String[] args) throws IOException {
		int port;
		ServerSocket ss = null;
		
		try {
			port = Integer.parseInt(args[0]);
		}
		catch (Exception e) {
			port = 1500;
			System.out.println("port = 1500 (default)");
		}
		
		try {
			ss = new ServerSocket(port);
			System.out.println("Server waiting for client. Port:" +
					ss.getLocalPort());
			} catch (IOException e) { 
				System.out.println(e); 
		}
		while(true) {
			new Thread(new Kiszolgalo(ss.accept())).start();
		}

	}

}
	
