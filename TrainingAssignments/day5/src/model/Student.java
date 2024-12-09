package model;

public class Student {
	int RollNo;
	String name;
	double fee;
	public Student() {
		
	}
	public Student(int rollNo, String name, double fee) {
		super();
		RollNo = rollNo;
		this.name = name;
		this.fee = fee;
	}
	public int getRollNo() {
		return RollNo;
	}
	public void setRollNo(int rollNo) {
		RollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Student [RollNo=" + RollNo + ", name=" + name + ", fee=" + fee + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
}
