package com.hexw.web.SController;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hexw.web.Student.Student;

@Controller
@RequestMapping("/students")
public class SController {
	List<Student> users;
	
	SController(){
		users=new ArrayList();
		users.add(new Student(101,"Aayush",5000));
		users.add(new Student(102,"Aayush1",6000));
		users.add(new Student(103,"Aayush2",7000));
		users.add(new Student(104,"Aayush3",8000));
	}
	
	@GetMapping("/allUsers")
	@ResponseBody
	List<Student> getData(){
		return users;
	}
	
	@GetMapping("searchbyroll/{rn}/{name}")
	@ResponseBody
	public Student getData(@PathVariable int rn,@PathVariable String name) {
		return (Student) users.stream().filter((t)->t.getRollno()==rn && t.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
	}
	
	@DeleteMapping("deletebyroll")
	@ResponseBody
	public List<Student> deleteData(@RequestParam int rn) {
		List<Student> r=users.stream().filter((t)->t.getRollno()!=rn).collect(Collectors.toList());
		return r;
	}
	
	
	@PostMapping("/savedata")
	@ResponseBody
	public List<Student> savedata(@RequestBody Student s)
	{
		users.add(s);
		return users;
	}
	
	@PutMapping("/updatedata/{rn}")
	@ResponseBody
	public List<Student> updatedata(@PathVariable int rn, @RequestBody Student s){
		Optional<Student> r=users.stream().filter((t)->t.getRollno()==rn).findFirst();
		Student st=r.get();
		st.setName(s.getName());
		st.setFee(s.getFee());
		
		return users;
	}
	
}
