package com.example.demo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public void test(){
        getCustomer(1); // cache bypassed
    }

    @Cacheable("customers")
    public String getCustomer(int id){
        System.out.println("Fetching data from database...");
        return "Customer-" + id;
    }
}