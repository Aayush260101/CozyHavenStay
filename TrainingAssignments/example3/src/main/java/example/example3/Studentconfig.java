package example.example3;

import org.springframework.context.annotation.Bean;

public class Studentconfig {
	@Bean(name="stud1")
	public Student getStudent() {
		Student obj=new Student();
		obj.setName("Aayush");
		obj.setRoll(101);
		return obj;
	}
	
	@Bean(name="stud2")
	public Student getStudent2() {
		Student obj=new Student();
		obj.setName("Aman");
		obj.setRoll(102);
		return obj;
	}
	
	@Bean(name="clg1")
	public College getCollege() {
		College obj1=new College();
		obj1.setCname("GEU");
		obj1.setCid(1101);
		return obj1;
	}
}
