package com.example.testtaskjavacode.repository;

import com.example.testtaskjavacode.DAO.Wallet;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Optional<Wallet> findByuuid(UUID valetId);
    List<Wallet> findAll();
    @Transactional
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Wallet save(Wallet newWallet);





}
