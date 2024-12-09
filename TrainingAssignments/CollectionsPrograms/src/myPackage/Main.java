package myPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        boolean flag=false;
        ArrayList<Bank> users =new ArrayList<Bank>();
 
        while (!exit) {
        	Bank.no_of_customers();
        	System.out.println("========= Main Menu =========");
            System.out.println("1. New Customer");
            System.out.println("2. Show All Customers");
            System.out.println("3. Show Balance");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Transfer");
            System.out.println("7. Close");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Creating a new customer...");
                    Bank b=new Bank();
                    
                    System.out.println("Enter name of customer");
                    scanner.nextLine();
                    b.setname(scanner.nextLine());
                    System.out.println("Enter Email of customer");
                    
                    b.setemail(scanner.nextLine());
                    System.out.println("Enter Balance of customer");
                    
                    b.setbalance(scanner.nextDouble());
                    users.add(b);
                    // Call a method to add a new customer
                    
                    break;
                case 2:
                    System.out.println("Showing all customers...");
                    
                    for(Bank b1:users)
                    {
                    	System.out.println(b1.toString());
                    }
                    break;
                case 3:
                	flag=false;
                    System.out.println("Showing Balance");
                    System.out.println("Enter Account no.");
                    int ac=scanner.nextInt();
                   
                    for(Bank b2 : users)
                    {
                    	if(b2.getActNo()==ac)
                    	{
                    		flag=true;
                    		System.out.println(b2.getbalance());
                    		break;
                    	}
                    }
                    if(flag==false)
                    {
                    	System.out.println("Account number not found");
                    }
                    break;
                case 4:
                	flag=false;
                    System.out.println("Depositing money...");
                    // Call a method to deposit money
                    System.out.println("Enter Account no.");
                    int ac1=scanner.nextInt();
                    
                    for(Bank b2 : users)
                    {
                    	if(b2.getActNo()==ac1)
                    	{
                    		flag=true;
                    		System.out.println("Enter amount to deposit");
                    		double bal = scanner.nextDouble();
                    		bal=bal+b2.getbalance();
                    		b2.setbalance(bal);
                    		System.out.println("Balane Updated");
                    		break;
                    	}
                    }
                    if(flag==false)
                    {
                    	System.out.println("Account number not found");
                    }
                    break;
                case 5:
                	flag=false;
                    System.out.println("Withdrawing money...");
                    System.out.println("Enter Account no.");
                    int ac2=scanner.nextInt();
                    
                    for(Bank b2 : users)
                    {
                    	if(b2.getActNo()==ac2)
                    	{
                    		flag=true;
                    		System.out.println("Enter amount to withdraw");
                    		double bal = scanner.nextDouble();
                    		double bal1=b2.getbalance();
                    		if(bal1>bal)
                    		{
                    			bal=bal1-bal;
                    			b2.setbalance(bal);
                    			System.out.println("Balance Updated");
                    		}
                    		else
                    		{
                    			System.out.println("Insufficient Balance");
                    		}
                    		break;
                    	}
                    }
                    if(flag==false)
                    {
                    	System.out.println("Account number not found");
                    }
                    break;
                case 6:
                    System.out.println("Transferring money...");
                    // Call a method to transfer money
                    System.out.println("Enter Account no. from which u have to withdraw");
                    int ac3=scanner.nextInt();
                    System.out.println("Enter Account no. to which you have to deposit");
                    int ac4=scanner.nextInt();
                    
                    boolean flag1=false,flag2=false;
                    int x1=0,x2=0;
                    for(int i=0;i<users.size();i++)
                    {
                    	if(users.get(i).getActNo()==ac3)
                    	{
                    		x1=i;
                    		flag1=true;
                    	}
                    	if(users.get(i).getActNo()==ac4)
                    	{
                    		x2=i;
                    		flag2=true;
                    	}
                    }
                    if(flag1==true && flag2==true)
                    {
                    	System.out.println("Enter Transfer Amount");
                    	double tr=scanner.nextDouble();
                    	Bank from_ac=users.get(x1);
                    	Bank to_ac=users.get(x2);
                    	double bal1=from_ac.getbalance();
                    	double bal2=to_ac.getbalance();
                    	bal1=bal1-tr;
                    	bal2=bal2+tr;
                    	from_ac.setbalance(bal1);
                    	to_ac.setbalance(bal2);
                    	System.out.println("Transfer Sucessful");
                    }
                    else
                    {
                    	System.out.println("Erong account information entered");
                    }
                    break;
                case 7:
                	System.out.println("Enter Account Number to close:");
                	int acToClose = scanner.nextInt();
                	boolean accountFound = false;

                	for (int i = 0; i < users.size(); i++) {
                	    if (users.get(i).getActNo() == acToClose) {
                	        users.remove(i);  // Remove the account from the list
                	        accountFound = true;
                	        System.out.println("Account " + acToClose + " has been closed successfully.");
                	        break;
                	    }
                	}

                	if (!accountFound) {
                	    System.out.println("Account number " + acToClose + " not found.");
                	}
                	break;

                case 8:
                    System.out.println("Exiting the application...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
        
        scanner.close();
    }
}