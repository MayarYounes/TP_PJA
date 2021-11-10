import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class class2 extends Employee {
	
	public class2(String name, String address, int SSN, int number) {
		
		   this.name = name;
		   this.address = address;
		   this.SSN = SSN;
		   this.number = number;
	   }
	

	public class DeserializeDemo
	{
	   public void main(String [] args)
	   {
	      Employee e = null;
	      try
	      {
	         FileInputStream fileIn = new FileInputStream("employee.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (Employee) in.readObject();
	         in.close();
	         fileIn.close();
	      }
	      catch(IOException i)
	      {
	         i.printStackTrace();
	         return;
	      }
	      catch(ClassNotFoundException c)
	      {
	         System.out.println("classe Employee non trouvee");
	         c.printStackTrace();
	         return;
	      }
	      System.out.println("Employee deserialise...");
	      System.out.println("Nom: " + e.name);
	      System.out.println("Adresse: " + e.address);
	      System.out.println("SSN: " + e.SSN);
	      System.out.println("Number: " + e.number);
	    }
	}

}
}
