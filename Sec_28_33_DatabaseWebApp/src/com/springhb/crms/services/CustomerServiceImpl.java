package com.springhb.crms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springhb.crms.daos.CustomerDAO;
import com.springhb.crms.entities.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO custDAO;
	
	// the service layer now manages the db transaction tasks (begin & commit transactions), not the DAOs anymore
	// the service layer returns the data from the db via the DAOs layer (services <-> DAOs <-> database)
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return custDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveClient(Customer c) {
		
		custDAO.saveCust(c);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		
		return custDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void removeCustomer(int id) {
		
		custDAO.eraseCustomer(id);
	}

}
