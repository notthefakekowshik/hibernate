package hibernateT;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;


public class Test 
{
	public static void main(String[] args) 
	{
		Alien kowshik = new Alien();
		kowshik.setId(0);
		kowshik.setAge(22);
		kowshik.setName("kowshik");
		
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction txc = session.beginTransaction();
		
		session.persist(kowshik);
		txc.commit();
	}
}
  