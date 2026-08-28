package com.example.payment;

public class PaymentProcessorFactory {

    public static PaymentProcessor create() {
        String impl = System.getProperty("payment.impl",
                        System.getenv().getOrDefault("PAYMENT_IMPL", "legacy"));

        return switch (impl.toLowerCase()) {
            case "new"    -> new NewPaymentProcessor();
            case "legacy" -> new LegacyPaymentProcessor();
            default -> throw new IllegalArgumentException("Unknown impl: " + impl);
        };
    }
}
