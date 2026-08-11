package com.bank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BankingService {

    private List<Customer> customers;
    private List<BankAccount> accounts;
    private List<Transaction> transactions;

    public BankingService() {
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    // -----------------------------
    // Add data
    // -----------------------------

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // -----------------------------
    // Get data
    // -----------------------------

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    // -----------------------------
    // Java 8 Stream - Filter
    // -----------------------------

    public List<Transaction> getHighValueTransactions(int amount) {

        Predicate<Transaction> highValue =
                transaction ->
                        transaction.getAmount() > amount;

        return transactions.stream()
                .filter(highValue)
                .collect(Collectors.toList());
    }

    // -----------------------------
    // Java 8 Stream - Sort
    // -----------------------------

    public List<Transaction> getTransactionsSortedByAmount() {

        return transactions.stream()
                .sorted(
                        Comparator.comparing(
                                Transaction::getAmount
                        )
                )
                .collect(Collectors.toList());
    }

    // -----------------------------
    // Java 8 Stream - Reduce
    // -----------------------------

    public int getTotalTransactionAmount() {

        return transactions.stream()
                .map(Transaction::getAmount)
                .reduce(
                        0,
                        Integer::sum
                );
    }

    // -----------------------------
    // Java 8 Stream - Map
    // -----------------------------

    public List<String> getCustomerNames() {

        return customers.stream()
                .map(Customer::getName)
                .collect(Collectors.toList());
    }
}