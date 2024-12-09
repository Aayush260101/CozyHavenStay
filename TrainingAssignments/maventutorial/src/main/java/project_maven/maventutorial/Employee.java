package project_maven.maventutorial;

public class Employee {
	int eno;
	String name;
	double salary;
	
	public Employee() {
		
	}
	public Employee(int eno, String name, double salary) {
		super();
		this.eno = eno;
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", name=" + name + ", salary=" + salary + "]";
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
