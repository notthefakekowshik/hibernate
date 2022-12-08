package hibernate_ManyToMany;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

public class Test {

	public static void main(String[] args) {
		
		Laptop l = new Laptop();
		l.setLaptopId(1);
		l.setLaptopName("lenovo");
		
		Laptop macBookAir = new Laptop();
		macBookAir.setLaptopId(2);
		macBookAir.setLaptopName("macBookAir laptop");
		
		Student s = new Student();
		s.setId(101);
		s.setName("kowshik");
		s.getLaptops().add(l);
		l.getStudents().add(s);
		
		
//		List<Laptop> curr = s.getLaptops();
//		for(int i = 0 ; i < curr.size();i++)
//		{
//			System.out.println(curr.get(i).getLaptopName());
//		}
		
//		Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
		
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction txc = session.beginTransaction();
		
		session.persist(l); 
		session.persist(s);
		

		txc.commit();
	}

}
