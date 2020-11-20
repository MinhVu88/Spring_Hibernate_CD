package com.springhb.crms.daos;

import java.util.List;

//import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.springhb.crms.entities.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	// the db transaction tasks have been moved to the service layer to be taken care of
	// the DAOs layer still manages retrieving the data from the db directly (DAOs <-> database)
	@Override
	//@Transactional
	public List<Customer> getCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	@Override
	public void saveCust(Customer c) {
		
		Session session = sessionFactory.getCurrentSession();
		
		// insert new data into the db
		//session.save(c);
		
		// save data if it's new or update it if it's already in the db
		session.saveOrUpdate(c);
	}

	@Override
	public Customer getCustomer(int id) {
		
		// retrieve the customer data from the db based on the id
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Customer.class, id);
	}

	@Override
	public void eraseCustomer(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Customer where id=:id");
		
		query.setParameter("id", id);
		
		query.executeUpdate();
	}

}
