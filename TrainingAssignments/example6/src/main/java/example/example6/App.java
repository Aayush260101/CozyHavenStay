package example.example6;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        SessionFactory fac;
        Session sess;

        fac = new Configuration().configure("hiber.config.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Result.class) 
                .buildSessionFactory();

        sess = fac.openSession();
        Transaction tax = sess.beginTransaction();

        
        Result r1 = new Result(105, 95, "DSA");
        Result r2 = new Result(106, 96, "C++");
        Result r3 = new Result(107, 97, "JAVA");
        Result r4 = new Result(108, 98, "DBMS");

        
        Student s = new Student();
        s.setRollNo(2);
        s.setName("Aman");

        List<Result> results = new ArrayList<>();
        results.add(r1);
        results.add(r2);
        results.add(r3);
        results.add(r4);
        
        
		
        for (Result result : results) {
            sess.save(result); 
        }
        s.setResults(results);
        sess.save(s);
        tax.commit(); 

        sess.close();
        fac.close();
    }
}
