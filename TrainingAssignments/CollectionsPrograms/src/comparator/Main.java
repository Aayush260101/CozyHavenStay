package comparator;

import java.util.*;

public class Main {
 
	public static void main(String[] args) {
		
		
		List <Student>users= new ArrayList();
		Student s1= new Student(101,"asha",20.0);
		Student s2= new Student(104,"jay",20.0);
 
		Student s3= new Student(108,"ajay",20.0);
 
		Student s4= new Student(109,"arti",20.0);
 
		Student s5= new Student(1099,"kavita",20.0);
		users.add(s1);
		users.add(s2);
 
		users.add(s3);
 
		users.add(s4);
		users.add(s5);
		
		Collections.sort(users, (student1,student2)->{return student1.getName().compareTo(student2.getName());});
 
 
		
		   for(Student s : users)
		   {
			   System.out.println(s.toString());
		   }
	}
 
}
