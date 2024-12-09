package comparable;

public class Student implements Comparable<Student> {
	 
	int Roll;
	String Name;
	int Marks;
	
	Student()
	{
	
	}
	
	public Student(int roll, String name, int marks) {
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
	public int getMarks() {
		return Marks;
	}
	public void setMarks(int marks) {
		Marks = marks;
	}
	
 
	@Override
	public String toString() {
		return "Student [Roll=" + Roll + ", Name=" + Name + ", Marks=" + Marks + "]";
	}

	@Override
	public int compareTo(Student o) {
		
		return this.Marks-o.Marks;
	}
	
	
	
	
	
}