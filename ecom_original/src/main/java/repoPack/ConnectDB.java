package repoPack;
import java.sql.*;


public class ConnectDB {
	static final String DB_URL = "jdbc:mysql://localhost:3306/coreJavaWorkshop?characterEncoding=utf8";
   static final String USER = "root";
   static final String PASS = "Kowshik1111475";
   public static Connection connectDB()
   {
	   Connection con = null;
	   try
	   {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   con = DriverManager.getConnection(DB_URL, USER, PASS);
	   }
	   catch(Exception e)
	   {
		   System.out.println(e.getMessage());
	   }
	   return con;
   }
   
		   
}