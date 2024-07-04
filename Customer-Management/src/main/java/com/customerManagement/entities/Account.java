package com.customerManagement.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    private String accountType;

    @DateTimeFormat
    Date accountOpeningDate;

    @DateTimeFormat
    Date lastActivity;
    
    private Long balance;

    
    private Long customerId;


}
