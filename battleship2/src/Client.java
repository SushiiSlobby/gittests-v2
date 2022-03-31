

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	private Socket socket;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private String username;
	private MyFrame frame;
	public Client(Socket socket, String username) {
		try {
			this.socket = socket;
			this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.username = username;
			frame = new MyFrame();
			//hopefully this will be accessible to all now
		}
		catch(IOException e) {
			closeEverything(socket, bufferedReader, bufferedWriter);
			
		}
	}
	
	public void sendMessage() {
		try {
			bufferedWriter.write(username);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			
			Scanner scanner = new Scanner(System.in);
			while (socket.isConnected()) {
				String messageToSend = scanner.nextLine(); // picks up message from console, just change this to recieve message from text box so no scanner
				bufferedWriter.write(username + ": " + messageToSend);
				bufferedWriter.newLine();
				bufferedWriter.flush();
			}
		}
		catch(IOException e) {
			closeEverything(socket, bufferedReader, bufferedWriter);
		}
	}
	public void listenForMessage() {
		new Thread(new Runnable() {
			//waits for messages that are sent by broadcastMessage() method in client handler
			@Override
			public void run() {
				String msgFromGroupChat;
				
				while(socket.isConnected()) {
					try {
						msgFromGroupChat = bufferedReader.readLine();
						System.out.println(msgFromGroupChat);
					}
					catch(IOException e) {
						closeEverything(socket, bufferedReader, bufferedWriter);
					}
				}
				
			}
			
		}).start();
	}
	
	public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
		try {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
			if (bufferedWriter != null) {
				bufferedWriter.close();
			}
			if (socket != null) {
				socket.close();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your username for the group chat: ");
		String username = scanner.nextLine();
		Socket socket = new Socket("localhost", 5000);
		Client client = new Client(socket, username);
		client.listenForMessage();
		client.sendMessage();
	}
}
