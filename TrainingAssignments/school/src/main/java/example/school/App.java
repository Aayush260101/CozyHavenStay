package example.school;

import java.util.List;
import java.util.Scanner;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App 
{
	SessionFactory fac;
	Session ses;
	App()
	{
		fac = new Configuration().configure("hiber.config.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
	}
	void addData(int roll,String name,double fee) {
		
		ses= fac.openSession();
        Transaction tax = ses.beginTransaction();
        int flag=0;
        Query <Student> q= ses.createQuery("from Student");
        List<Student> slist = q.list();
        for(Student s : slist)
        {
        	if(s.getRollno()==roll)
        	{
        		flag=1;
        	}
        }
        if(flag==0)
        {
        	Student st = new Student();
        	st.setRollno(roll);
        	st.setName(name);
        	st.setFee(fee);
        	ses.save(st);
        	tax.commit();
        	
            System.out.println( "Data Saved" );
        }
        else {
        	System.out.println("Roll no Already exists");
        }
    	
	}
	void removeData(int roll) {
		ses= fac.openSession();
        Transaction tax = ses.beginTransaction();
        String str="delete from Student where rollno =:rn";
        Query q=ses.createQuery(str);
        q.setParameter("rn", roll);
        int c=q.executeUpdate();
        tax.commit();
        if(c>0) {
        	
        	System.out.println("Removed");
        }
        else {
        	System.out.println("Not Removed");
        }
	}
	void updateFee(int roll,double fe) {
		ses= fac.openSession();
        Transaction tax = ses.beginTransaction();
        String str="update Student set Fee=:fn where rollno =:rn";
        Query q=ses.createQuery(str);
        q.setParameter("fn", fe);
        q.setParameter("rn", roll);
        int c=q.executeUpdate();
        tax.commit();
        
if(c>0) {
        	
        	System.out.println("Updated");
        }
        else {
        	System.out.println("Not Updated");
        }
	}
	void updateFee2(int roll,double fe) {
		ses= fac.openSession();
        Transaction tax = ses.beginTransaction();
        Student s=ses.find(Student.class,roll);
        if(s!=null) {
        	
        	s.setFee(s.getFee()+fe);
        	ses.saveOrUpdate(s);
        	tax.commit();
        	System.out.println("Updated");
        }
        else {
        	System.out.println("Not Found");
        }
	}
	void show() {
		ses= fac.openSession();
        Transaction tax = ses.beginTransaction();
        Query <Student> q= ses.createNativeQuery("Select * from Studentdata",Student.class);
        
        
		/*
		 * q.setFirstResult((pn-1)*ps); q.setMaxResults(ps);
		 */
        List<Student> slist = q.list();
        for(Student s : slist)
        {
        	System.out.println(s.toString());
        }
        tax.commit();
	}
	void searchRollName(int rn,String nm)
	  {
		  
		  ses = fac.openSession();
		     
		     Transaction tax=ses.beginTransaction();
		     
		     Query <Student> q=ses.createQuery("from Student stud where stud.rollno=:rn and stud.name=:nm");
		     q.setParameter("rn", rn);
		     q.setParameter("nm", nm);
		     
		  List<Student>slist=   q.list();
		     
		     for(Student s :slist )
		     {
		    	 System.out.println(s.toString());
		     }
		     
		     
		     
	  }
	void searchRollFee(int rn,double fe)
	  {
		  
		  ses = fac.openSession();
		     
		     Transaction tax=ses.beginTransaction();
		     
		     Query <Student> q=ses.createQuery("from Student stud where stud.rollno=:rn and stud.fee=:fe");
		     q.setParameter("rn", rn);
		     q.setParameter("fe", fe);
		     
		  List<Student>slist=   q.list();
		     
		     for(Student s :slist )
		     {
		    	 System.out.println(s.toString());
		     }
		     
		     
		     
	  }
	void showfee() {
		ses= fac.openSession();
        Transaction tax = ses.beginTransaction();
        Query <Student> q= ses.createQuery("from Student");
        List<Student> slist = q.list();
        for(Student s : slist)
        {
        	if(s.getFee()>1000 && s.getFee()<=2000)
        	System.out.println(s.toString());
        }
	}
    public static void main( String[] args )
    {
    	App app=new App();
    	//app.addData();
    	Scanner sc=new Scanner(System.in);
    	//System.out.println("Enter roll no.");
    	//int f=sc.nextInt();
    	//sc.nextLine();
    	//System.out.println("Enter Name");
    	//String nam=sc.nextLine();
    	//app.removeData(f);
    	//System.out.println("Enter fee");
    	//double fe=sc.nextDouble();
    	//app.update)Fee(f,fe);
    	app.show();
    	//app.addData(f,nam,fe);
    	//app.searchRollName(f, nam);
    	//app.showfee();
    	//app.searchRollFee(f, fe);
    }
}
