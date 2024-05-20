package com.example.testtaskjavacode.repository;

import com.example.testtaskjavacode.DAO.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findByuuid(UUID valetId);
}
