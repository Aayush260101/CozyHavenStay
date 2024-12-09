package com.hexw.web.LController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hexw.web.Login.Login;



@Controller
@RequestMapping("/user")
public class LController {
	List<Login> li;
		
	LController(){
		li= new ArrayList<>();
		li.add(new Login(101,"Aayush","1234"));
	}
	
	@GetMapping("/allusers")
	@ResponseBody
	List<Login> getData(){
		return li;
	}
	
	@GetMapping("/login/{name}/{pass}")
	@ResponseBody
	public String login(@PathVariable String name,@PathVariable String pass) {
		String str;
		Optional<Login> li1=  li.stream().filter((t)->t.getName().equals(name) && t.getPassword().equals(pass)).findFirst();
		if(li1.isPresent())
		{
			str="Login Successful";
		}
		else
		{
			str="No User Found";
		}
		return str;
	}
	
	@PostMapping("/signup")
	@ResponseBody
	public List<Login> signup(@RequestBody Login l) {
		li.add(l);
		return li;
	}
	
	@PutMapping("/updatepassword/{id}")
	@ResponseBody
	public List<Login> updatepassword(@PathVariable int id, @RequestBody Login l){
		Optional<Login> li2=li.stream().filter((t)->t.getUid()==id).findFirst();
		if(li2.isPresent()) {
			Login l1=li2.get();
			l1.setPassword(l.getPassword());
		}
		return li;
	}
	
	@DeleteMapping("removeaccount/{id}")
	@ResponseBody
	public List<Login> deleteaccount(@PathVariable int id) {
		
		li= li.stream().filter((t)->t.getUid()!=id).collect(Collectors.toList());
		
		return li;
		
	}
	
}
