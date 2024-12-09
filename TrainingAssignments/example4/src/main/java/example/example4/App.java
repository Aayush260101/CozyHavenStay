package example.example4;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
 
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Scanner;
 
public class App {
 
    SessionFactory fac;
    Session ses;
 
    public App() {
        fac = new Configuration().configure("hiber.config.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }
 
    void addData() {
        try {
            ses = fac.openSession();
            Transaction tax = ses.beginTransaction();
 
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter fee: ");
            double fee = sc.nextDouble();
            sc.nextLine(); // consume newline
            System.out.print("Enter image file path: ");
            String imagePath = sc.nextLine();
 
            Student s = new Student();
            s.setName(name);
            s.setFee(fee);
            s.setImage(loadImage(imagePath));
 
            ses.save(s);
            tax.commit();
            System.out.println("Data saved");
        } finally {
            ses.close();
        }
    }
 
    byte[] loadImage(String imagePath) {
        try {
            File file = new File(imagePath);
            FileInputStream fis = new FileInputStream(file);
            byte[] imageData = new byte[(int) file.length()];
            fis.read(imageData);
            fis.close();
            return imageData;
        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
            return null;
        }
    }
 
    void removeData(int roll) {
        ses = fac.openSession();
        Transaction tax = ses.beginTransaction();
 
        Student s = ses.find(Student.class, roll);
        if (s != null) {
            ses.delete(s);
            tax.commit();
            System.out.println("Data removed");
        } else {
            System.out.println("Student not found");
        }
    }
 
    void updateFee(int roll, double fee) {
        ses = fac.openSession();
        Transaction tax = ses.beginTransaction();
 
        Student s = ses.find(Student.class, roll);
        if (s != null) {
            s.setFee(fee);
            ses.saveOrUpdate(s);
            tax.commit();
            System.out.println("Fee updated");
        } else {
            System.out.println("Student not found");
        }
    }
 
    void showAllStudents() {
        ses = fac.openSession();
        Transaction tax = ses.beginTransaction();
 
        Query<Student> query = ses.createQuery("from Student", Student.class);
        List<Student> students = query.list();
 
        for (Student s : students) {
            System.out.println(s);
        }
    }
 
    void searchByRollName(int rollno, String name) {
        ses = fac.openSession();
        Transaction tax = ses.beginTransaction();
 
        Query<Student> query = ses.createQuery("from Student stud where stud.rollno=:rollno and stud.name=:name", Student.class);
        query.setParameter("rollno", rollno);
        query.setParameter("name", name);
 
        List<Student> students = query.list();
        for (Student s : students) {
            System.out.println(s);
        }
    }
 
    public static void main(String[] args) {
        App app = new App();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Update Fee");
            System.out.println("4. Show All Students");
            System.out.println("5. Search Student by Roll and Name");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
 
            switch (choice) {
                case 1:
                    app.addData();
                    break;
                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int roll = sc.nextInt();
                    app.removeData(roll);
                    break;
                case 3:
                    System.out.print("Enter roll number: ");
                    roll = sc.nextInt();
                    System.out.print("Enter new fee: ");
                    double fee = sc.nextDouble();
                    app.updateFee(roll, fee);
                    break;
                case 4:
                    app.showAllStudents();
                    break;
                case 5:
                    System.out.print("Enter roll number: ");
                    int rollNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    app.searchByRollName(rollNo, name);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
