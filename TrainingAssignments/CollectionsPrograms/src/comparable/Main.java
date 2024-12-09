package comparable;

import java.util.*;


public class Main {
 
	public static void main(String[] args) {
		List <Student>users= new ArrayList ();
		
		// u1   u2
		
		Student s1= new Student(101,"asha",91);
		Student s2= new Student(104,"jay",12);
 
		Student s3= new Student(108,"ajay",89);
 
		Student s4= new Student(109,"arti",70);
 
		Student s5= new Student(1099,"kavita",20);
		
		
		users.add(s1);
		users.add(s2);
 
		users.add(s3);
 
		users.add(s4);
 
		users.add(s5);
 
 
		   Collections.sort(users);
		   
		   for(Student s : users)
		   {
			   System.out.println(s.toString());
		   }
 
	}
 
}