package com.hexaware.website;

import java.util.List;
import java.util.Scanner;
import org.hibernate.query.Query;

import example.school.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	SessionFactory fac;
	Session ses;
	App(){
		fac = new Configuration().configure("hiber.config.xml").
        		addAnnotatedClass(User.class).buildSessionFactory();
	}
	//========================================================================================
	void signUp(String uname, String email, String pwd, String cpwd) {
		ses = fac.openSession();
        Transaction tax = ses.beginTransaction();
        User u = ses.find(User.class, uname);
        if(u!=null) {
        	System.out.println("Data Already Present");
        }else if(pwd.equals(cpwd)){
        	u = new User();
        	u.setUsername(uname);
        	u.setEmail(email);
        	u.setPassword(cpwd);
        	u.setActive(0);
        	ses.saveOrUpdate(u);
        	tax.commit();
        	System.out.println("User created");
        }else {
        	System.out.println("Password and Confirm Password do not match. Please try Again!!!");
        }
	}
	//========================================================================================================
	void logIn(String uname, String pwd) {
		ses = fac.openSession();
        Transaction tax = ses.beginTransaction();
        
        String str="from User where username=:un and password=:pw";
        Query q= ses.createQuery(str);
        q.setParameter("un", uname);
        q.setParameter("pw", pwd);
        List<User> ulist = q.list();
        
        tax.commit();
        if(!ulist.isEmpty()) {
        	User u = ulist.get(0);
        	u.setActive(1);
        	ses.update(u);
        	tax.commit();
            System.out.println("Login successful. User set to active.");          
        }else {
        	System.out.println("No User Found. Please Check Username or Sign Up before Log In!!!");
        }
	}
	//=============================================================================================================
	void updatePassword(String uname, String opwd, String npwd, String cpwd) {
		ses = fac.openSession();
        Transaction tax = ses.beginTransaction();
        User u = ses.find(User.class, uname);
        if(u!=null) {
        	if(u.getActive()==1){
        		if(opwd.equals(u.getPassword())) {
            		if(npwd.equals(cpwd)) {
            			u.setPassword(cpwd);
            			ses.saveOrUpdate(u);
                    	tax.commit();
                    	System.out.println("Password Updated");
            		}else {
            			System.out.println("New Password and Confirm New Password do not match. Please try Again!!!");
            		}
                }else{
                	System.out.println("Enter Correct Old Password. Please try Again!!!");
                }
        	}else {
        		System.out.println("User Not Logged In");
        	}
        }else {
        	System.out.println("No User Found. Please Check Username or Sign Up before Log In!!!");
        }		
	}
	//===========================================================================================================================
	boolean logOut(String uname) {
		ses = fac.openSession();
        Transaction tax = ses.beginTransaction();
        User u = ses.get(User.class, uname);
        if(u != null && u.getActive()==1) {
        	System.out.println("Thank You. Please Visit Again!");
        	System.out.println("Logging Out");
        	u.setActive(0);
        	ses.saveOrUpdate(u);
        	tax.commit();
        	return true;
        }else {
        	System.out.println("User Not Logged In");
        	return false;
        }
		
	}
	//===================================================================================================================
	void deleteAcoount(String uname, String pwd) {
		ses = fac.openSession();
        Transaction tax = ses.beginTransaction();
        User u = ses.find(User.class, uname);
        if(u!=null) {
        	if(pwd.equals(u.getPassword()) && u.getActive()==1) {
//        		Query<User> q= ses.createQuery("from User where username = :uname and password = :pwd");
//        		q.setParameter("uname", uname);
//                q.setParameter("pwd", pwd);
//                List<User> slist = q.list();
                ses.remove(u);
            	tax.commit();
            	System.out.println("Account Closed");
            }else if(u.getActive()==0){
            	System.out.println("User Not Logged In");
            }else {
            	System.out.println("Enter Correct Password. Please try Again!!!");
            }
        }else {
        	System.out.println("No User Found. Please Check Username or Sign Up before Log In!!!");
        }
	}
	//====================================================================================================================
	public static void main( String[] args )
    {
		App app = new App();
		System.out.println( "Welcome" );
        Scanner sc = new Scanner(System.in);
        boolean exit = true;
        while(exit) {
        	System.out.println( "==============================" );
            System.out.println( "Here is your Main Menu" );
            System.out.println("1. Sign Up");
            System.out.println("2. Log In");
            System.out.println("3. Update Password");
            System.out.println("4. Log Out");
            System.out.println("5. Delete Account");
            System.out.println( "==============================" );
            System.out.println("Enter you Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();
            switch(ch) {
            case 1:
            	{
            		System.out.println("Enter Username :");
            		String uname = sc.nextLine();
            		System.out.println("Enter Email :");
            		String email = sc.nextLine();
            		System.out.println("Enter Password :");
            		String pwd = sc.nextLine();
            		System.out.println("Confirm Password :");
            		String cpwd = sc.nextLine();
            		app.signUp(uname,email,pwd,cpwd);
            		break;
            	}
            	
            case 2:
            	{
            		System.out.println("Enter Username :");
                    String uname = sc.nextLine();
                    System.out.println("Enter Password :");
            		String pwd = sc.nextLine();
            		app.logIn(uname,pwd);
            		break;
            	}
            	
            case 3:
            	{
            		System.out.println("Enter Username :");
                    String uname = sc.nextLine();
            		System.out.println("Enter Old Password :");
                    String opwd = sc.nextLine();
                    System.out.println("Enter New Password :");
            		String npwd = sc.nextLine();
                    System.out.println("Enter Confirm New Password :");
            		String cpwd = sc.nextLine();
            		app.updatePassword(uname,opwd,npwd,cpwd);
            		break;
            	}
            	
            case 4:
            	{
            		System.out.println("Enter Username :");
                    String uname = sc.nextLine();
            		if(app.logOut(uname))	exit=false;
                	break;
            	}
            	
            case 5:
            	{
            		System.out.println("Enter Username :");
                    String uname = sc.nextLine();
            		System.out.println("Enter Password :");
                    String pwd = sc.nextLine();
                    app.deleteAcoount(uname,pwd);
                    break;
            	}
            	
            default:
            	{
            		System.out.println("Invalid Option");
            		break;
            	}
            }
        }
        sc.close();
        
    }
}

