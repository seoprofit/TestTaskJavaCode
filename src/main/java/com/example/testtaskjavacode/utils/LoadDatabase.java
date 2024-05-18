package com.example.testtaskjavacode.utils;


import com.example.testtaskjavacode.model.Wallet;
import com.example.testtaskjavacode.model.WalletModel;
import com.example.testtaskjavacode.repository.WalletRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class LoadDatabase {

@Bean
    CommandLineRunner initDB (WalletRepository walletRepository)
{
    return args -> {

        walletRepository.save(new Wallet(1231, WalletModel.OperationType.DEPOSIT, new BigDecimal(12000)));
        walletRepository.save(new Wallet(141421, WalletModel.OperationType.WITHDRAW, new BigDecimal(500)));
        walletRepository.save(new Wallet(242121, WalletModel.OperationType.DEPOSIT, new BigDecimal(15000)));
        walletRepository.save(new Wallet(8655, WalletModel.OperationType.WITHDRAW, new BigDecimal(8000)));
        walletRepository.save(new Wallet(5237865, WalletModel.OperationType.DEPOSIT, new BigDecimal(100)));


    };

}



}


