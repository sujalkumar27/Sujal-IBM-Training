package com.bank;

import java.time.LocalDate;

public class Transaction {
    private int amount;
    private LocalDate date;

    public Transaction(int amount, LocalDate date){
        this.amount= amount;
        this.date= date;
    }
    public int getAmount(){
        return this.amount;

    }
    public LocalDate getDate(){
        return this.date;
    }

    @Override
    public String toString() {
        return "Transaction { amount="+amount+ " date="+date+"}";
    }
}
