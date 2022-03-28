import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class multiServer {
	private static String[] names = {"Wily", "Felix", "Carlsbad", "Hobo"};
	private static String[] adjs = {"the gentle", "the un-gentle", "the overwrought", "the urbane"};
	
	private static ArrayList<clientHandler> clients = new ArrayList<>();
	private static ExecutorService pool = Executors.newFixedThreadPool(4);
	
	
	
	public static void main(String[] args) throws IOException{
		ServerSocket listener = new ServerSocket(5000);
		
		while (true) {
			try {
				System.out.println("[ser] conec try");
				Socket client = listener.accept();
				System.out.println("[ser] found yay");
				clientHandler clientThread = new clientHandler(client, clients);
				clients.add(clientThread);
				
				pool.execute(clientThread);
			}
			catch (IOException e)
			{
				System.out.println(e);
				break;
				
			}
			
			
			
		}
		
		
	}
	
	public static String getRandomName() {
		String name = names[(int) (Math.random() * names.length)];
		String adj = adjs[(int) (Math.random() * adjs.length)];
		return name + " " + adj;
	}
}
