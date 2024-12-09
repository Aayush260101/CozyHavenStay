package comparator;
import java.util.Comparator;

public class Rollcom  implements Comparator<Student>{
 
 
	public int compare(Student o1, Student o2) {
		
		return o1.Roll-o2.Roll;
	}
 
}