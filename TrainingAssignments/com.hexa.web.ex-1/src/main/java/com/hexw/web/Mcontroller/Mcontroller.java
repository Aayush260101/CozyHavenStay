package com.hexw.web.Mcontroller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Mcontroller {
		
	 
	@GetMapping("/home")
	
	public 	String home()
	{
			return ("home");
			
	}
	
	@GetMapping("/about")
	
	public String aboutus()
    {
		return ("contact");
			
	}
		
		
}

