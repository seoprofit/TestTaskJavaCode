package com.example.testtaskjavacode.service;

import com.example.testtaskjavacode.DAO.Wallet;
import com.example.testtaskjavacode.DTO.WalletDTO;
import com.example.testtaskjavacode.exception.MyEx;
import com.example.testtaskjavacode.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WalletService {

    private WalletRepository walletRepository;

    @Autowired
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet save(Wallet newWallet) {
        return walletRepository.save(newWallet);
    }


    public List<Wallet> findAll() {
        return walletRepository.findAll();
    }

    public WalletDTO findByuuid(UUID valetId) {
                 return walletRepository.findByuuid(valetId).converterToDTO();

    }

    public Wallet updateExistWallet(WalletDTO newWalletDTO, UUID waletId) throws MyEx {
        WalletDTO oldWalletDTO;

if ((oldWalletDTO = walletRepository.findByuuid(waletId).converterToDTO()) != null) {

    if (newWalletDTO.getOperationType() == WalletDTO.OperationType.DEPOSIT) {
        oldWalletDTO.setAmount(oldWalletDTO.converterToDAO().getAmount().add(newWalletDTO.getAmount()));
    } else if (newWalletDTO.getOperationType() == WalletDTO.OperationType.WITHDRAW) {
        if ((oldWalletDTO.getAmount().compareTo(newWalletDTO.getAmount())) >= 0)
            oldWalletDTO.setAmount(oldWalletDTO.getAmount().subtract(newWalletDTO.getAmount()));
        else System.out.println("Error"); System.out.println(oldWalletDTO.toString());
    }
}
else System.out.println("No one this UUID");

            return walletRepository.save(oldWalletDTO.converterToDAO());

    }







}


