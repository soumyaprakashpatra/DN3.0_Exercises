package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.entity.Customer;
import com.example.BookstoreAPI.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Endpoint to process JSON request body
    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    // Endpoint to process form data
    @PostMapping("/register/form")
    public ResponseEntity<Customer> registerCustomerForm(@RequestParam Map<String, String> formData) {
        Customer customer = new Customer();
        customer.setName(formData.get("name"));
        customer.setEmail(formData.get("email"));
        customer.setPhone(formData.get("phone"));
        Customer createdCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }
}
