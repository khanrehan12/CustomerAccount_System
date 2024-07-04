package com.customerManagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerManagement.entities.Customer;
import com.customerManagement.exception.GlobalException;
import com.customerManagement.exception.NotAcceptableException;
import com.customerManagement.exception.ResourceNotFoundException;
import com.customerManagement.responses.ApiResponse;
import com.customerManagement.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@Slf4j
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	String msg = "";

	// Add a customer
	@PostMapping("/customerAdd")
	public ApiResponse createUser(@RequestBody Customer customer) {
		List<Customer> allCust = customerService.getAllCustomer();
		if (customer.getName().length() < 3) {
			throw new NotAcceptableException("Customer name must be contains minimum 3 latter");
		} else if (customer.getPhone().length() >= 11 || customer.getPhone().length() < 10) {
			throw new NotAcceptableException("Customer Phone must be unique and must be equal to 10 digits only.");
		} else {
			for (Customer existingCustomer : allCust) {
				if (existingCustomer.getPhone().equals(customer.getPhone())) {
					throw new NotAcceptableException("Customer phone No must be unique !!");
				}else if(existingCustomer.getEmail().equals(customer.getEmail())) {
					throw new NotAcceptableException("Customer Email must be unique !!");
				}
			}
		}
		if (customer.getAddress().isEmpty()) {
			throw new NotAcceptableException("Customer Address must not be empty.");
		}
		if (customer.getCity().isEmpty()) {
			throw new NotAcceptableException("Customer City name must not be empty");

		} else {
			customerService.createCustomer(customer);
			return new ApiResponse("Customer Added successfully..", true);
		}
	}

	// Get All customer
	@GetMapping("/getAllCustomer")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomer());
	}

	// Get Single Customer by customerId Id
	@GetMapping("/getCustomer/{customerId}")
	public ResponseEntity<?> getCustomer(@PathVariable Long customerId) {
		List<Customer> findAll = customerService.getAllCustomer();
		for (Customer f1 : findAll) {
			if (f1.getCustomerId().equals(customerId)) {
				return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomer(customerId));
			}
		}
		throw new ResourceNotFoundException("CustomerId not found Please try again with correct CustomerId !!");
	}

	// Update Customer details
	@PutMapping("/updateCustomer/{customerId}")
	public ApiResponse updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId) {
		List<Customer> updateCust = customerService.getAllCustomer();
		for (Customer updt : updateCust) {
			if (updt.getCustomerId().equals(customerId)) {
				if (customer.getName().length() < 3) {
					throw new NotAcceptableException("Customer name must be contains minimum 3 latter");
				} else if (customer.getPhone().length() >= 11 || customer.getPhone().length() < 10) {
					throw new NotAcceptableException("Customer Phone number must be equal to 10 digits only.");
				} else if (customer.getEmail().isEmpty()) {
					throw new NotAcceptableException("Customer email must not be empty !!");
				} else if (customer.getAddress().isEmpty()) {
					throw new NotAcceptableException("Customer Address must not be empty.");
				} else if (customer.getCity().isEmpty()) {
					throw new NotAcceptableException("Customer City name must not be empty");

				} else {
					customer.setCustomerId(customerId);
					customerService.createCustomer(customer);
					return new ApiResponse("Customer is Successfully Updated !!", true);
				}
			}
		}
		throw new ResourceNotFoundException("Customer Id Not Found Please enter correct Id !!");
	}

	// Delete a Customer
	@DeleteMapping("/deleteCustomer/{customerId}")
	public ApiResponse deletezCustomer(@PathVariable Long customerId) {
		customerService.delete(customerId);
		return new ApiResponse(" Customer is Successfully Deleted !!", true);
	}

}
