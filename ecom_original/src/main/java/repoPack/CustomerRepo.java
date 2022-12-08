package repoPack;

import java.sql.Connection;
import java.sql.*;
import beansPack.Customer;

public class CustomerRepo 
{
	public boolean addNewCustomer(Customer c)
	{
		boolean flag = false;
		Connection con = ConnectDB.connectDB();
		return flag;
	}
	public boolean customerLogin(Customer c)
	{
		boolean flag = false;
		try
		{
			Connection con = ConnectDB.connectDB();
			PreparedStatement stmt = con.prepareStatement("select customerUserName,customerPassword from customerLogin");
			ResultSet rs = stmt.executeQuery();
			int count = 0;
			while(rs.next())
			{
				count+=1;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return flag;
	}
}
