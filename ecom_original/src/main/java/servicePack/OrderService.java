package servicePack;

import java.util.List;

import beansPack.Customer;
import beansPack.Order;

public interface OrderService 
{
	public List<Order> displayOrders();
	public void createOrder(Customer c);
	public void updateExistingOrder();
}	
