package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;


    @GetMapping("/{id}")
    public String getCustomer(@PathVariable int id) {

        return service.getCustomer(id);
    }
}