package com.springhb.crms.daos;

import java.util.List;

import com.springhb.crms.entities.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCust(Customer c);

	public Customer getCustomer(int id);

	public void eraseCustomer(int id);
}
