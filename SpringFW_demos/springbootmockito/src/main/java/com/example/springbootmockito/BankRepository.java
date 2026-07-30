package com.example.springbootmockito;
import com.example.springbootmockito.BankAccount;

public interface BankRepository {

    BankAccount findByAccountNumber(String accountNumber);
    void save(BankAccount account);

}
