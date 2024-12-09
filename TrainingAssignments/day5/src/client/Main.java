package client;

import java.util.List;
import java.util.Scanner;


import model.Student;
import service.StudentService;



public class Main {
	private static final Scanner scanner = new Scanner(System.in);
	private static final StudentService ss = new StudentService();
	public static void main(String args[])
	{
		while (true) {
            System.out.println("Welcome to StudentData!");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Show all Student");
            System.out.println("4. Update Fee");
            System.out.println("5. Remove By Fee");
            System.out.println("6. Search Student");
            System.out.println("7. Increase Fee");
            System.out.println("8. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    getAllStudents();
                    break;
                case 4:
                    updateFee();
                    break;
                case 5:
                    removeByFee();
                    break;
                case 6:
                    searchStudent();
                    break;
                case 7:
                    increaseFee();
                    break;
                case 8:
                    System.out.println("Exiting the application...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
	}
	
	private static void addStudent() {
		int temp=0;
        System.out.print("Enter Roll: ");
        int roll = scanner.nextInt();
        List<Student> students= ss.showAllStudents();
        for(Student st : students) {
			 if(roll==st.getRollNo()) {
				 temp=1;
			 }
		}
        if(temp==1)
        {
        	System.out.println("This Roll No. already exists");
        }
        else {
        System.out.print("Enter Name: ");
        String Name = scanner.next();
        System.out.print("Enter Fee: ");
        Double fee = scanner.nextDouble(); 
        
        Student student = new Student();
        student.setRollNo(roll);
        student.setName(Name);
        student.setFee(fee);
        ss.addStudent(student);
        System.out.println("Student added successfully!");
        }
    }
	
	private static void removeStudent() {
		System.out.print("Enter Roll: ");
        int roll = scanner.nextInt();
        ss.removeStudent(roll);
        System.out.println("Student Deleted Successfully");
	}
	
	private static void removeByFee() {
		System.out.print("Enter Fee below which you want to remove : ");
        double fee = scanner.nextDouble();
        ss.removeByFee(fee);
        System.out.println("Student Deleted Successfully");
	}
	
	public static void getAllStudents() {
		List<Student> students= ss.showAllStudents();
		if(students.isEmpty())
		{
			System.out.println("No Students Found");
		}
		else
		{
			System.out.println("All Students");
			for(Student st : students) {
				 System.out.printf("Roll: %d, Name: %s, Fee: %f\n",st.getRollNo(), st.getName(),st.getFee());	                        
			}
		}
	}
	
	public static void updateFee() {
		System.out.print("Enter Roll: ");
        int roll = scanner.nextInt();
        System.out.print("Enter Updated Fee: ");
        double fee = scanner.nextDouble();
        ss.updateFee(roll, fee);
        System.out.println("Fee Updated Successfully");
	}
	
	public static void increaseFee() {
		System.out.print("Enter Roll: ");
        int roll = scanner.nextInt();
        System.out.print("Enter increased value of Fee: ");
        double value = scanner.nextDouble();
        ss.increaseFee(roll, value);
        System.out.println("Fee Increased Successfully");
	}
	
	public static void searchStudent() {
		System.out.print("Enter RollNo of Student : ");
        int roll = scanner.nextInt();
        Student st=ss.searchStudent(roll);
        if(st==null)
        {
        	System.out.println("No Record Found");
        }
        else
        System.out.println(st.toString());
	}


}
