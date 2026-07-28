package com.sujal;

public class DebitCardPayment implements PaymentService {
    @Override
    public void pay(double amount) {

        System.out.println("payment of Rs:"+amount+" using the debit card service");
    }
}
