package com.example.testtaskjavacode.utils;


import com.example.testtaskjavacode.DAO.Wallet;
import com.example.testtaskjavacode.DTO.WalletDTO;
import com.example.testtaskjavacode.repository.WalletRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.UUID;

@Configuration
public class LoadDatabase {

    UUID uuid_for_tests = UUID.fromString("c302ea4b-5c88-413b-aa26-813baf374460");
    @Bean
    CommandLineRunner initDB(WalletRepository walletRepository) {
        return args -> {
            walletRepository.save(new Wallet(uuid_for_tests, new BigDecimal(50000)));
            walletRepository.save(new Wallet(UUID.randomUUID(), new BigDecimal(1500)));
            walletRepository.save(new Wallet(UUID.randomUUID(), new BigDecimal(78545)));
            walletRepository.save(new Wallet(UUID.randomUUID(), new BigDecimal(1005)));
            walletRepository.save(new Wallet(UUID.randomUUID(), new BigDecimal(890)));
            walletRepository.save(new Wallet(UUID.randomUUID(), new BigDecimal(10098)));

        };
    }
}


