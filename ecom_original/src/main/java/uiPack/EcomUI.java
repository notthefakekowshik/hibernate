package uiPack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import beansPack.Customer;
import exceptionsPack.InvalidInput;
import serviceImplPack.CustomerServiceImpl;


public class EcomUI 
{
	public static void showMenu()
	{
		
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try
		{
			while(true)
			{
				System.out.println("Enter 1 if you are a new user and 2 if you are an old customer and 0 to exit");
				int option = sc.nextInt();
				if(option == 1)
				{
					CustomerServiceImpl cs = new CustomerServiceImpl();
					cs.addNewCustomer();
				}
				else if(option == 2)
				{
					CustomerServiceImpl cs = new CustomerServiceImpl();
					cs.customerLogin();
				}
				else if(option == 0)
				{
					System.out.println("Thank you! Bye");
				}
				else
				{
					throw new InvalidInput("Cant enter the other options");
				}
			}
		}
		catch(InvalidInput ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
