package serviceImplPack;

import beansPack.Address;
import beansPack.Customer;
import exceptionsPack.InvalidPhoneNumber;
import exceptionsPack.InvalidUserName;
import repoPack.ConnectDB;
import repoPack.CustomerRepo;
import servicePack.CustomerService;

import java.sql.*;
import java.util.*;

public class CustomerServiceImpl implements CustomerService 
{
	Customer c = new Customer();
	Address a = new Address();
	CustomerRepo cr = new CustomerRepo();
	Scanner sc = new Scanner(System.in);
	public boolean addNewCustomer() 
	{
		boolean flag = false;
		try
		{
			
			System.out.println("Enter your name");
			String customerName = sc.next();
			
			System.out.println("Enter your phone number");
			long customerPhNo = sc.nextLong();
			
			if(String.valueOf(customerPhNo).length()!=10)
			{
				throw new InvalidPhoneNumber("Phone number should have 10 digits!");
			}
			else if(!(String.valueOf(customerPhNo).charAt(0) >= '6' && String.valueOf(customerPhNo).charAt(0) <= '9' ))
			{
				throw new InvalidPhoneNumber("Phone number should start between 6 and 9");
			}
			
			System.out.println("Enter your street name");
			String streetName = sc.next();
			a.setStreet(streetName);
			
			
			System.out.println("Enter your city name");
			String cityName = sc.next();
			a.setCity(cityName);
			
			
			System.out.println("Enter the pin code");
			int pincode = sc.nextInt();
			a.setPincode(pincode);
			
			
			System.out.println("Enter your user name");
			String userName = sc.next();
			
			
			
			//checking the username in the database.
			Connection con = ConnectDB.connectDB();
			PreparedStatement stmt = con.prepareStatement("select customerUserName from customerLogin where customerUserName =? ");
			stmt.setString(1,userName);
			ResultSet rs = stmt.executeQuery();
			int count = 0 ;
			while(rs.next())
			{
				count+=1;
			}
			if(count == 0)
			{
				throw new InvalidUserName("User name in already taken");
			}
			else
			{
				c.setCustomerUsername(userName);
				System.out.println("Enter the password");
				String customerPass;
				customerPass = sc.next();
			}
			CustomerRepo cr = new CustomerRepo();
			return cr.addNewCustomer(c);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

	public boolean updateCustomerDetails() 
	{
		boolean flag = false;
		return flag;
	}

	public boolean customerLogin() 
	{
		boolean flag = false;
		System.out.println("Enter your username");
		c.setCustomerUsername(sc.next());
		System.out.println("Enter your password");
		c.setCustomerPassword(sc.next());
		flag = cr.customerLogin(c);
		return flag;
	}

}
