package project_maven.maventutorial;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
		/*
		 * Employee e=(Employee)context.getBean("empobj1");
		 * System.out.println(e.toString());
		 */
        
        Department dept=(Department)context.getBean("deptobj");
        System.out.println(dept.toString());
    }
    
}
