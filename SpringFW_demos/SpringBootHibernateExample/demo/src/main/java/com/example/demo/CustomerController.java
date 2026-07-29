package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    // Insert Customer
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    // Get All Customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }
}