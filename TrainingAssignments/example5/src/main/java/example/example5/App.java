package example.example5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import example.example5.Student;

public class App 
{
	
    
	
    public static void main( String[] args )
    {
    	
    	SessionFactory fac;
    	Session sess;
    	
    	
        fac = new Configuration().configure("hiber.config.xml")
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();
    	
	    sess = fac.openSession();
		
        Transaction tax = sess.beginTransaction();
        Address a1=new Address();
        a1.setHouse_no(101);
        a1.setCity("Mumbai");
        Student s = new Student();
        s.setRoll(1);
        s.setName("Ajay");
        s.setAddress(a1);
        sess.save(s);
        tax.commit(); // Commit the transaction to save changes

        sess.close();
        fac.close();
    }
    	
}
