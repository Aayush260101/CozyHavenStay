package BankDetails;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID: ");
        int empId = sc.nextInt();
        sc.nextLine(); 
        System.out.println("Enter Employee Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Employee Salary: ");
        double salary = sc.nextDouble();
        System.out.println("Choose Employee Type:");
        System.out.println("1. Temporary Employee");
        System.out.println("2. Permanent Employee");
        int choice = sc.nextInt();
        Employee emp = null;
        if (choice == 1) {
            emp = new Temporary(empId, name, salary);
        } else if (choice == 2) {
            emp = new Permanent(empId, name, salary);
        } else {
            System.out.println("Invalid choice.");
            return;
        }
        emp.calBon();
        emp.show();

        sc.close();
    }
}
