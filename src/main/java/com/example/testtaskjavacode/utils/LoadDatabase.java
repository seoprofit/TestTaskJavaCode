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

    @Bean
    CommandLineRunner initDB(WalletRepository walletRepository) {
        return args -> {
            walletRepository.save(new WalletDTO(UUID.randomUUID(), WalletDTO.OperationType.DEPOSIT, new BigDecimal(95500)).converterToDAO());
            walletRepository.save(new WalletDTO(UUID.randomUUID(), WalletDTO.OperationType.DEPOSIT, new BigDecimal(5500)).converterToDAO());
            walletRepository.save(new WalletDTO(UUID.randomUUID(), WalletDTO.OperationType.DEPOSIT, new BigDecimal(15000)).converterToDAO());
            walletRepository.save(new WalletDTO(UUID.randomUUID(), WalletDTO.OperationType.WITHDRAW, new BigDecimal(8000)).converterToDAO());
            walletRepository.save(new WalletDTO(UUID.randomUUID(), WalletDTO.OperationType.DEPOSIT, new BigDecimal(100)).converterToDAO());
        };
    }
}


