package com.customerManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customerManagement.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
