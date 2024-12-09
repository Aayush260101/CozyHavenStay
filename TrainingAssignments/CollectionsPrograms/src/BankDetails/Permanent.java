package BankDetails;

public class Permanent extends Employee{
	    public Permanent() {
	        super();
	    }  
	    public Permanent(int empId, String name, double salary) {
	        super(empId, name, salary);
	    }
	    @Override
	    void calBon() {
	        setBonus(getSalary() * 10 / 100);
	    }
}
