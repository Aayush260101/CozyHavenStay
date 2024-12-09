package example.example3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args )
    {      
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(Studentconfig.class);
        
        College ct = (College)context.getBean("clg1");
        System.out.println(ct.toString());
    }
}
