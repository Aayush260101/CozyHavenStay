package comparator;

public class Student {
	 
	int Roll;
	String Name;
	Double Marks;
	
	Student()
	{
	
	}
	
	public Student(int roll, String name, Double marks) {
		super();
		Roll = roll;
		Name = name;
		Marks = marks;
	}
 
	public int getRoll() {
		return Roll;
	}
	public void setRoll(int roll) {
		Roll = roll;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Double getMarks() {
		return Marks;
	}
	public void setMarks(Double marks) {
		Marks = marks;
	}
	@Override
	public String toString() {
		return "Student [Roll=" + Roll + ", Name=" + Name + ", Marks=" + Marks + "]";
	}
	
}
