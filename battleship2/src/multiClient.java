import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

//testing

public class multiClient {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("104.255.205.33", 5000);
		
		ServerConnection serverConn = new ServerConnection(socket);
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); 
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		runner run = new runner();
		
		
		new Thread(serverConn).start();
		
		while (true) {
			System.out.print("> ");
			String command = keyboard.readLine();
			
			if (command.equals("quit")) break;
			
			out.println(command);
			
		}
		socket.close();
		System.exit(0);
	}
}
