package com.example.checkout;

import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

    private final FeatureFlags flags;

    public CheckoutService(FeatureFlags flags) {
        this.flags = flags;
    }

    public String checkout(String cartId, double amount) {
        if (flags.isNewCheckout()) {
            return newCheckout(cartId, amount);
        }
        return oldCheckout(cartId, amount);
    }

    private String oldCheckout(String cartId, double amount) {
        return "[OLD] checkout for " + cartId + " amount=" + amount;
    }

    private String newCheckout(String cartId, double amount) {
        return "[NEW] fast checkout for " + cartId + " amount=" + amount +
               " (with saved-cards + one-tap)";
    }
}
