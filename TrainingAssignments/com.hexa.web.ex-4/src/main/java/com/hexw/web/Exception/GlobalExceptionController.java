package com.hexw.web.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public    ResponseEntity<ErrorDetails> noCustomerF(CustomerNotFoundException ex)
	{
		ErrorDetails error= new ErrorDetails(LocalDateTime.now(),ex.getMessage(),"location not found ","No_Customer_Found");
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerNotAddedException.class)
	public    ResponseEntity<ErrorDetails> noCustomerAdded(CustomerNotAddedException ex)
	{
		ErrorDetails error= new ErrorDetails(LocalDateTime.now(),ex.getMessage(),"location not found ","No_Customer_Added");
		
		return new ResponseEntity<>(error,HttpStatus.NOT_IMPLEMENTED);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> defexce(Exception ex)
	{
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),"Location not Found","Some Kind of Error Occured");
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


