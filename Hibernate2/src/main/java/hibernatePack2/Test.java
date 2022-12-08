package hibernatePack2;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;    
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;  
  
public class Test {  
  
    public static void main( String[] args )  
    {  
    	try
    	{
//    		Configuration con = new Configuration().configure();  
//            
//            SessionFactory sf = con.buildSessionFactory();
//       
//           Session session = sf.openSession();  
//           Transaction t = session.beginTransaction();  
             
           
           StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
           Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
         
       SessionFactory factory = meta.getSessionFactoryBuilder().build();  
       Session session = factory.openSession();  
       Transaction t = session.beginTransaction();   
           
            Employee e1=new Employee();    
               e1.setId(101);    
               e1.setFirstName("elon musk");    
               e1.setLastName("N");    
//            
////          Query q = session.createQuery("from emp");
////          List results =q.list();
////          Iterator it = results.iterator();
////          while(it.hasNext())
////          {
////        	  System.out.println(it.next());
////          }
//          session.persist(e1);
       
          
          
          t.commit();    
          factory.close();  
           session.close();
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
        System.out.println("inserted");
    }  
}  
