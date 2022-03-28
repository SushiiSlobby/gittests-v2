import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class multiClient {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("192.168.1.169", 5000);
		
		ServerConnection serverConn = new ServerConnection(socket);
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); 
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		MyFrame a = new MyFrame();
		
		
		new Thread(serverConn).start();
		
		while (true) {
			try {
				String command = a.text;
				if (command.equals("quit")) break;
				out.println(command);
				a.text = null;
			}
			catch(Exception e) {
				
			}
//			System.out.print("> ");
//			String command = keyboard.readLine();
//			
//			if (command.equals("quit")) break;
//			
//			out.println(command);
			
		}
		socket.close();
		System.exit(0);
	}
}
