package com.hexw.web.Entity;

public class CustomerDTO {
	int actno;
	String name;
	double fee;
	public int getActno() {
		return actno;
	}
	public void setActno(int actno) {
		this.actno = actno;
	}
	public String getName() {
		return name;
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
	public CustomerDTO() {
		
	}
	public CustomerDTO(int actno, String name, double fee) {
		super();
		this.actno = actno;
		this.name = name;
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "CustomerDTO [actno=" + actno + ", name=" + name + ", fee=" + fee + "]";
	}
}
