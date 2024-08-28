
// src/main/java/com/yourcompany/bookstoreapi/service/CustomerService.java
package com.example.BookstoreAPI.service;

import com.example.BookstoreAPI.entity.Customer;
import com.example.BookstoreAPI.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
