package com.customerManagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="customerService")
public class Customer {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Long customerId;
	  
	  @Column(name="customer_name")
	  private String name;
	  
	  @Column(name="customer_phone")
	  private String phone;
	  
	  @Column(name="customer_email")
	  private String email;
	  
	  @Column(name="customer_address")
	  private String address;
	  
	  @Column(name="customer_city")
	  private String city;

}
