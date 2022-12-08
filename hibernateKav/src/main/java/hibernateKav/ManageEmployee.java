package hibernateKav;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class ManageEmployee 
{
	public void addEmployee(int id , String name,int age)
	{
		Employee e = new Employee(id,name,age);
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session se = sf.openSession();
		
		Transaction txc = se.beginTransaction();
		se.persist(e);
		txc.commit();
		System.out.println("persisted");
	}
	
}
