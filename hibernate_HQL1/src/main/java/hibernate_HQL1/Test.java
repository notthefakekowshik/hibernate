package hibernate_HQL1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.Transaction;

import java.util.*;
public class Test 
{
	public static void main(String[] args) 
	{
		Alien kowshik = new Alien();
		kowshik.setAge(22);
		kowshik.setName("kowshik");
		

		
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction txc = session.beginTransaction();
		
		//session.persist(kowshik);
		
//		for(int i = 0;i<50;i++)
//		{
//			Alien curr = new Alien();
//			curr.setAge(i);
//			curr.setName("kowshik");
//			session.persist(curr);
//		}
		
		Query q = session.createQuery("from alienTable where id < 50");
		List<Alien> aliens= q.list();
		 
		for(Alien curr : aliens)
		{
			System.out.println(curr.getId()+ " "+curr.getName());
		}
		txc.commit();
	}
}
  