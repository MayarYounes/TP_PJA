import java.util.Scanner;
import java.net.*;
import java.io.*;

public class ServDev {
	public static void SocketConnect(Socket c) {
		PrintWriter out = null;
        String clientInput = null;
        BufferedReader input = null;
        try {
        	out = new PrintWriter(c.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(c.getInputStream()));
            clientInput = input.readLine();
            if(clientInput.equals("cat")){
            System.out.println("Client input : "+ clientInput);
        	File dir = new File("C:\\Users\\teste\\Desktop\\cat");
            if(dir.isDirectory()){
            	String[] files = dir.list();
            for(int i=0 ; i< files.length ; i++) {
                out.println(files[i]);// envoi depuis le serveur
                clientInput = input.readLine();// reception de la reponse du client
            	}
            }else {
            	System.out.println("no files ");
            }}
           else {
            if(clientInput.equals("fichier1.txt")){
            Scanner sc = new Scanner(new File("C:\\Users\\teste\\Desktop\\cat\\fichier1.txt"));
            while (sc.hasNext()) {
               	String line = sc.nextLine();
                System.out.println(line);
               // sc.close();
            					}
            }else {
            	System.out.println("reecrire le nom du dossier ou du fichier");
            }
            }
            }catch (Exception e) {
                e.printStackTrace();
            } finally {
                    try {
                       c.close();
                        System.out.println("Client Socket is closed");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
		
	}

	public static void main(String[] args) {
		
      	   
          
      	   try {
	            ServerSocket serverSocket = new ServerSocket(9090);
	            System.out.println("waiting for clients...");
	            while (true) {
	                Socket socket = serverSocket.accept();
	                SocketConnect(socket);
	  		  }
	           }	   
	         catch(Exception e){
	            System.out.println(e.toString());
	        }
		 
	}}
