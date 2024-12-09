package comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class xyz {
	public static void main(String args[])
	{
		List <Integer> al = new ArrayList();
		al.add(24);
		al.add(42);
		al.add(23);
		al.add(2);
		al.add(21);
		al.add(4);
		
		//al.stream().filter((t)->t>20).forEach((i)->System.out.println(i));
		
		/*
		 * List<Integer>
		 * evenNumbers=al.stream().filter((i)->i%2==0).collect(Collectors.toList());
		 * System.out.println(evenNumbers);
		 */
		
		List <String>users=new ArrayList();
		users.add("asha");
		users.add("jatin");
		users.add("kavita");
		users.add("deepa");
		users.add("parul");
		//users.stream().filter((temp)-> temp.contains("u")).forEach((i)->System.out.println(i));
		
		List <Student>users1= new ArrayList();
		Student s1= new Student(101,"asha",20.0);
		Student s2= new Student(104,"jay",80.0);
 
		Student s3= new Student(108,"ajay",70.0);
 
		Student s4= new Student(109,"arti",20.0);
 
		Student s5= new Student(1099,"kavita",90.0);
		users1.add(s1);
		users1.add(s2);
 
		users1.add(s3);
 
		users1.add(s4);
		users1.add(s5);
		//users1.stream().filter((temp)->temp.getMarks()>20).forEach((temp2)->System.out.println(temp2.toString()));
		
		
		users1.stream()
		.sorted(Comparator.comparingInt(Student::getRoll))
		.forEach(System.out::println);
				
				
				
		users1.stream()
		.sorted(Comparator.comparing(Student::getName))
		.forEach(System.out::println);
				
				
		Student maxStudent = users1.stream()
		.max(Comparator.comparingDouble(Student::getMarks))
		.orElse(null);  // Returns null if the list is empty
		 
		if (maxStudent != null) {
		System.out.println("Student with highest marks: " + maxStudent);
		} else {
		System.out.println("No students available.");
		}
		
	}

}
