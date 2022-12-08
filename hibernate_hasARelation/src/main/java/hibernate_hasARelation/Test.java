package hibernate_hasARelation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;


public class Test 
{
	public static void main(String[] args) 
	{
		Name n = new Name();
		n.setFirstName("N");
		n.setLastName("Kowshik");
		
		Alien kowshik = new Alien();
		kowshik.setAge(22);
		kowshik.setId(1);
		kowshik.setName(n);
		
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction txc = session.beginTransaction();
		
		session.persist(kowshik);
		 
		txc.commit();
	}
}
  