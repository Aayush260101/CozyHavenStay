package example.example7;
 
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class App {
    public static void main(String[] args) {
        SessionFactory fac;
        Session sess;
 
        // Configure and build the session factory
        fac = new Configuration().configure("config.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Result.class)
                .buildSessionFactory();
 
        // Open session
        sess = fac.openSession();
 
        // Start a transaction
        Transaction tax = sess.beginTransaction();
 
       
        int rollNo = 2; // Replace with the roll number you want to fetch
        
        Student student = sess.get(Student.class, rollNo);
        
        // student   result
 
        if (student != null) {
            System.out.println("Student Name: " + student.getName());
            System.out.println("Roll No: " + student.getRollNo());
            
          // List<Result> results = student.getResults();        
            //System.out.println(results.size());
 
            
         
        } else {
            System.out.println("Student not found with roll number: " + rollNo);
        }
 
      
        tax.commit();
 
       
        sess.close();
        fac.close();
    }
}