package BankDetails;

public class Temporary extends Employee{
	
    public Temporary() {
        super();
    }
    public Temporary(int empId, String name, double salary) {
        super(empId, name, salary);
    }  
    @Override
    void calBon() {
        setBonus(getSalary() * 5 / 100);
    }
}
