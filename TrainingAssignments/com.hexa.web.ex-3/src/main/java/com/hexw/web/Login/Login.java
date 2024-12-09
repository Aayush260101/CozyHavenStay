package com.hexw.web.Login;

public class Login {
	int uid;
	String name;
	String password;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [uid=" + uid + ", name=" + name + ", password=" + password + "]";
	}
	public Login() {
		
	}
	public Login(int uid, String name, String password) {
		super();
		this.uid = uid;
		this.name = name;
		this.password = password;
	}
	
}
