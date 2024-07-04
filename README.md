# Created Backend Functionality for Banking Application using Microservices

------------  API URLs for Customer Services --------------

*** using API-GATEWAY port no for both the services ***

# Add Customer details
1. http://localhost:8080/customerService/customerAdd 
  
   {
    "name":"Nagarro Demo",
    "phone":"1111111111",
    "email":"nagarro@gmail.com",
    "address":"Mahindra-SEZ NH76",
    "city":"Jaipur"
   } 

# Fetch All the customer details
2. http://localhost:8080/customerService/getAllCustomer

# Get Single Customer details
3. http://localhost:8080/customerService/getCustomer/{customerId}

# Update Customer details 
4. http://localhost:8080/customerService/updateCustomer/{customerId}
      {
       "name": "Demo",
       "phone": "1234567890",
       "email": "demo@gmail.com",
       "address": "Testing NH76",
       "city": "Test"
      }

# Delete Customer details & if customer Id is also mapped to customer account then that account also delete.
5. http://localhost:8080/customerService/deleteCustomer/{customerId}




------------  API URLs for Account Services --------------

# Add Account
1. http://localhost:8080/accountService/accountAdd
   {
    "accountType":"current",
    "balance":400000,
    "customerId": {customerId}
   }

# Get All Account 
2. http://localhost:8080/accountService/getAllAccount

# Delete Account
3. http://localhost:8080/accountService/deleteAccount/{accountId}

# Get Single Account using Customer Id
4. http://localhost:8080/accountService/customer/{customerId}

# Delete Account using Customer Id
5. http://localhost:8080/accountService/customerDelete/{customerId}
   
# Add Money to account
6. http://localhost:8080/accountService/addBalance/{accountId}?amount={amount}&customerId={customerId}

# Withdraw money from account
7. http://localhost:8080/accountService/withdrawBalance/{accountId}?amountWithdraw={amountWithdraw}&customerId={customerId}



---------  All The services are listed below for Banking Application Project ----------------

# SERVICE-DISCOVERY(EUREKA SERVER) is running on port --> 8761 
# CONFIG-SERVER is running on port --> 8085
# API-GATEWAY is running on port   --> 8080
# CUSTOMERSERVICE is running on port --> 9001
# ACCOUNTSERVICE is running on port  --> 9002


