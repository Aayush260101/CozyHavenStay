package com.hexw.web.Entity;

import jakarta.persistence.Entity;


import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Customer {
	@Id
	int actno;
	@Pattern(regexp = "^[A-Z a-z]{5}", message = "Name error")
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
	@Override
	public String toString() {
		return "Customer [actno=" + actno + ", name=" + name + ", fee=" + fee + "]";
	}
	public Customer() {
		
	}
	public Customer(int actno, String name, double fee) {
		super();
		this.actno = actno;
		this.name = name;
		this.fee = fee;
	}
	
}
