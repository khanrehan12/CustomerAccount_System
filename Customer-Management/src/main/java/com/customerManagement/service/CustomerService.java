package com.customerManagement.service;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.customerManagement.entities.Customer;

@Service
public interface CustomerService {
	
	// create a customer account
	public Customer createCustomer(Customer customer);
	
	// get all customer account
	public List<Customer> getAllCustomer();
	
	// get single customer account by customerId
	public Optional<Customer> getCustomer(Long customerId);
	
	// update customer account 
	public Customer updateCustomer(Customer customer); 
	
	// delete customer account by using customerId
	public void delete(Long customerId);

}
