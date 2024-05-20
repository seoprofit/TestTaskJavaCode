package com.example.testtaskjavacode.service;

import com.example.testtaskjavacode.DAO.Wallet;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WalletService {
    Optional<Wallet> findByuuid(UUID walletId);

    List<Wallet> findAll();

    Wallet save(Wallet newWallet);
}
