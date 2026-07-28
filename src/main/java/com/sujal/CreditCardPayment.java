package com.sujal;

public class CreditCardPayment implements PaymentService {
    @Override
   public void pay(double amount){
        System.out.println("payment of Rs:"+amount+" using the creding card");
    }

}
