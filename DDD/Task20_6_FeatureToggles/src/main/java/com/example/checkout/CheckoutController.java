package com.example.checkout;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    private final CheckoutService service;

    public CheckoutController(CheckoutService service) {
        this.service = service;
    }

    public record CheckoutRequest(String cartId, double amount) {}

    @PostMapping
    public String checkout(@RequestBody CheckoutRequest req) {
        return service.checkout(req.cartId(), req.amount());
    }
}
