package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.dto.CustomerDTO;
import com.example.BookstoreAPI.entity.Customer;
import com.example.BookstoreAPI.mapper.CustomerMapper;
import com.example.BookstoreAPI.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers().stream()
                .map(CustomerMapper.INSTANCE::customerToCustomerDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CustomerDTO addCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.INSTANCE.customerDTOToCustomer(customerDTO);
        Customer savedCustomer = customerService.saveCustomer(customer);
        return CustomerMapper.INSTANCE.customerToCustomerDTO(savedCustomer);
    }
}
