package com.example.minibankingspringboot.repository;

import com.example.minibankingspringboot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
