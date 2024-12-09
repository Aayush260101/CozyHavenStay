package example.example2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import example.example2.Student;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext Context= new ClassPathXmlApplicationContext("config.xml");
        Student st=(Student)Context.getBean("empobj");
        System.out.println(st.toString());
        Student st1=(Student)Context.getBean("empobj1");
        System.out.println(st1.toString());
    }
}
