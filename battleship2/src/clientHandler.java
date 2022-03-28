import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class clientHandler implements Runnable{
	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	private ArrayList<clientHandler> clients;
	
	public clientHandler(Socket clientSocket, ArrayList<clientHandler> clients) throws IOException {
		this.clients = clients;
		this.client = clientSocket;
		in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		out = new PrintWriter(client.getOutputStream(), true);
	}
	@Override
	public void run() {
		try {
			while (true) {
			String request = in.readLine();
			
			if (request.contains("name")) {
				out.println(multiServer.getRandomName());
			}
			else if(request.startsWith("say")){
				int firstSpace = request.indexOf(' ');
				if (firstSpace != -1) {
					outToAll(request.substring(firstSpace +1));
				}
				
			}
			else {
				out.println("Type 'tell me a name' to get a random name");
			}
		}
		}
		catch(IOException e) {
			System.err.println("IO exception in client handler");
			System.err.println(e.getStackTrace());
			
		}
		
		finally {
			System.out.println("[ser] a user has left");
			out.close();
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
				
			}
		}
		
	}
	private void outToAll(String msg) {
		for (clientHandler aClient : clients) {
			aClient.out.println(msg);
		}
		
	}
	
}
