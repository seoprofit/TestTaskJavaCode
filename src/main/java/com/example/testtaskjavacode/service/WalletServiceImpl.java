package com.example.testtaskjavacode.service;

import com.example.testtaskjavacode.DAO.Wallet;
import com.example.testtaskjavacode.DTO.WalletDTO;
import com.example.testtaskjavacode.exception.AccountNotFoundEx;
import com.example.testtaskjavacode.exception.BadQueryEx;
import com.example.testtaskjavacode.exception.BalanceNotEnoughEx;
import com.example.testtaskjavacode.repository.WalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class WalletServiceImpl implements WalletService {

    private WalletRepository walletRepository;

    @Autowired
    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }


    public Optional<Wallet> findByuuid(UUID walletId) {
        Optional<Wallet> walletDTO = walletRepository.findByuuid(walletId);
        return walletDTO;
    }

    public List<Wallet> findAll() {
        return walletRepository.findAll();
    }


    public Wallet save(Wallet newWallet) {
        return walletRepository.save(newWallet);
    }

    @Transactional
    public Wallet updateExistWallet(WalletDTO newWalletDTO) throws AccountNotFoundEx, BalanceNotEnoughEx, BadQueryEx {
        if (newWalletDTO == null) throw new BadQueryEx("Some troubles with your request body");
        else {

                WalletDTO oldWalletDTO = walletRepository.findByuuid(newWalletDTO.getUuid()).orElseThrow(() -> new AccountNotFoundEx("Account with UUID: " + newWalletDTO.getUuid() + " was not found")).converterToDTO();
                if (newWalletDTO.getOperationType() == WalletDTO.OperationType.DEPOSIT) {
                    oldWalletDTO.setAmount(oldWalletDTO.converterToDAO().getAmount().add(newWalletDTO.getAmount()));
                } else if (newWalletDTO.getOperationType() == WalletDTO.OperationType.WITHDRAW) {
                    if ((oldWalletDTO.getAmount().compareTo(newWalletDTO.getAmount())) >= 0) {
                        oldWalletDTO.setAmount(oldWalletDTO.getAmount().subtract(newWalletDTO.getAmount()));

                    } else
                        throw new BalanceNotEnoughEx("Account with UUID: " + newWalletDTO.getUuid() + " has not enough balance");
                }
                return walletRepository.save(oldWalletDTO.converterToDAO());

        }
    }
}


