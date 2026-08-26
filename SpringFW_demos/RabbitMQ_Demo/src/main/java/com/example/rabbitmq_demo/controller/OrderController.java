package com.example.rabbitmq_demo.controller;

import com.example.rabbitmq_demo.producer.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping
    public String createOrder(@RequestParam String order) {

        orderProducer.sendOrder(order);

        return "Order sent: " + order;
    }
}