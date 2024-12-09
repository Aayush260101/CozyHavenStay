package Filereading;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;

public class Main {
	
	 
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter id");
			String id = sc.nextLine();
			System.out.println("Enter Password");
			String pass = sc.nextLine();
			String id1 = null,pass1 = null;
			Properties pr= new Properties();
			try
			{
				
				FileInputStream f1= new FileInputStream("C:\\Users\\aayus\\eclipse-workspace\\CollectionsPrograms\\src\\db.properties");
				pr.load(f1);
				
				id1=pr.getProperty("uid");
				pass1=pr.getProperty("upassword");
			}
			catch(Exception e)
			{
				
				System.out.println(e.getMessage());
			}
			
			if(id.equals(id1))
			{
				if(pass.equals(pass1))
				{
					System.out.println("Logged in Sucessfully");
				}
				else
				{
					System.out.println("Wrong Password");
				}
			}
			else
			{
				System.out.println("Wrong Id");
			}
	 
		}
	 
	}

