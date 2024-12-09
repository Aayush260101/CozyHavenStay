package com.hexw.web.Exception;

public class RoleNotFoundException extends Exception{
	String msg;
	public RoleNotFoundException(String msg) {
		this.msg=msg;
	}
	
	public String getMessage() {
		return msg;
	}
}
