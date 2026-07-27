package com.sujal;

public class Demo02DiApplication {

    public static void main(String[] args) {

        // Inject CreditCardPayment
        PaymentService paymentService = new CreditCardPayment();
        OrderService orderService = new OrderService(paymentService);

        orderService.placeOrder(250.00);

        // Inject DebitCardPayment
        PaymentService debitPayment = new DebitCardPayment();
        OrderService orderService2 = new OrderService(debitPayment);

        orderService2.placeOrder(150.00);
    }

}
