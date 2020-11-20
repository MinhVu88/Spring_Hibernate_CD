package com.springhb.crms.services;

import java.util.List;

import com.springhb.crms.entities.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveClient(Customer c);

	public Customer getCustomer(int id);

	public void removeCustomer(int id);
}
