import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;


public class class1 extends Employee {

	public class1(String name, String address, int SSN, int number) {
		
			   this.name = name;
			   this.address = address;
			   this.SSN = SSN;
			   this.number = number;
		   }
	
	public class SerializeDemo {
		
		public void main(String [] args) {
			
			try {
				
				System.out.println("entrez le numéro :");
				Scanner sc = new Scanner(System.in);
				int N = sc.nextInt();
				Employee [] e = new Employee[N];
		        FileOutputStream fileOut = new FileOutputStream("employee.ser",true);
		        ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         
					for(int i=0 ; i<N ; i++) {
						System.out.println("entrez le nom :");
						String n = sc.nextLine();
						sc.nextLine();
						System.out.println("entrez l'adresse :");
						String a = sc.nextLine();
						System.out.println("entrez SSN :");
						String s = sc.nextLine();
						System.out.println("entrez le nombre :");
						int num = sc.nextInt();
						
						out.writeObject(e);
		         
				    }
		         out.close();
		         fileOut.close ();
		         System.out.printf("donnees serialisees sauvegardees dans employee.ser");
		         
			 }
			 catch(IOException i) {
		          i.printStackTrace();
		     }
			
		}
				
	 }
}
