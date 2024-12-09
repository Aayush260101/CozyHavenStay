package com.hexw.web.Exception;

public class CustomerNotAddedException extends Exception{
	String msg;
	public CustomerNotAddedException(String msg)
	{
		super();
		this.msg=msg;
	}
	
	public String getMessage() {
		return msg;
	}
}
