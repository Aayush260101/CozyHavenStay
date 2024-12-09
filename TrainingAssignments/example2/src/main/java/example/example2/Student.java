package example.example2;

public class Student {
	int sid;
	String name;
	double marks;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", marks=" + marks + "]";
	}
	public Student(int sid, String name, double marks) {
		super();
		this.sid = sid;
		this.name = name;
		this.marks = marks;
	}
	public Student() {
		
	}
}
