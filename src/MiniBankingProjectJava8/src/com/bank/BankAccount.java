package com.bank;

public class BankAccount {

    private int accountNumber;
    private Customer customer;
    private int balance;

    public BankAccount(
            int accountNumber,
            Customer customer) {

        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = 0;
    }

    public void deposit(int amount) {

        if (amount <= 0) {
            System.out.println(
                    "Invalid deposit amount"
            );
            return;
        }

        balance += amount;

        System.out.println(
                "₹" + amount +
                        " deposited successfully"
        );
    }

    public void withdraw(int amount) {

        if (amount <= 0) {
            System.out.println(
                    "Invalid withdrawal amount"
            );
            return;
        }

        if (amount > balance) {
            System.out.println(
                    "Insufficient balance"
            );
            return;
        }

        balance -= amount;

        System.out.println(
                "₹" + amount +
                        " withdrawn successfully"
        );
    }

    public int getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}