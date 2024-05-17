package com.example.testtaskjavacode.repository;

import com.example.testtaskjavacode.model.Wallet;
import com.example.testtaskjavacode.model.WalletModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {



}
