package com.hexw.web.Exception;

public class CustomerNotFoundException extends Exception{
	String msg;
	public CustomerNotFoundException(String msg){
		super();
		this.msg=msg;
	}
	public String getMessage() {
		return msg;
	}
}
