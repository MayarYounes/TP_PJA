
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClientDev {
    private static final String SERVER_IP = "127.0.0.1";
	static int SERVER_PORT = 9090;

	public static void main(String[] args) throws IOException{
	        Socket socket = null;
	        PrintWriter out = null;
	        BufferedReader in = null;
	        Scanner sc;
	        String serverResponse = null;
	        try {
	            socket = new Socket(SERVER_IP, SERVER_PORT);
	            out = new PrintWriter(socket.getOutputStream(), true);
	            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            sc = new Scanner(System.in);
	            do {
	            	out.println (sc.nextLine()); // sending message to server
	                serverResponse = in.readLine(); // reading server reply
	                System.out.println("Server response: "+ serverResponse);
	            } while (!serverResponse.isEmpty());
	        } catch(Exception e){
	                System.out.println("Exception occured " + e.getMessage());
	        }
	        finally {
	            out.close();
            // socket.close();
	        }
	    }
	}


