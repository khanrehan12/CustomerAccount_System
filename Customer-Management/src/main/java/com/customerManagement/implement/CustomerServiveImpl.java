package com.customerManagement.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.customerManagement.config.RestConfig;
import com.customerManagement.entities.Customer;
import com.customerManagement.exception.ResourceNotFoundException;
import com.customerManagement.repository.CustomerRepository;
import com.customerManagement.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomerServiveImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
    private RestTemplate restTemplate;

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> getCustomer(Long customerId) {
		return customerRepository.findById(customerId);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void delete(Long customerId) {

		Customer customer = this.customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("given Customer id not found"));
		restTemplate.delete("http://AccountService/customerDelete/" + customer.getCustomerId());
		this.customerRepository.delete(customer);
	}

}
