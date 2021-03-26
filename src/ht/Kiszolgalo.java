package ht;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Kiszolgalo implements Runnable {
	private Socket so;
	
	public Kiszolgalo(Socket so) {
		this.so = so;
	}

@Override
public void run() {
	BufferedReader bf;
	
	try {
		bf = new BufferedReader (new InputStreamReader(so.getInputStream()));
		String line = bf.readLine();
		
		
		
		String doksi = "beolvasott.txt";
		PrintWriter pw = new PrintWriter(new FileOutputStream(doksi, true));
		String timeStamp = String.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date().getTime()));
		System.out.println(timeStamp + " : " + line);
		pw.append(timeStamp + " : " + line + "\n");

		
		pw.flush();
		bf.close();
		pw.close();
		
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
