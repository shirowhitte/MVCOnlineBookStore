package dao;

import model.Customer;

public interface customerDao {
	Customer login(int username, String password);
	int registerCustomer(Customer customer);
	String getCustomerName(int username);
}
