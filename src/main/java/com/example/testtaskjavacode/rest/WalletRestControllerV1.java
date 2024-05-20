package com.example.testtaskjavacode.rest;

import com.example.testtaskjavacode.DAO.Wallet;
import com.example.testtaskjavacode.DTO.WalletDTO;
import com.example.testtaskjavacode.exception.AccountAlreadyExistsEx;
import com.example.testtaskjavacode.exception.AccountNotFoundEx;
import com.example.testtaskjavacode.exception.BadQueryEx;
import com.example.testtaskjavacode.exception.BalanceNotEnoughEx;
import com.example.testtaskjavacode.service.WalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class WalletRestControllerV1 {

    private WalletServiceImpl walletServiceImpl;
    @Autowired
    public WalletRestControllerV1(WalletServiceImpl walletServiceImpl) {
        this.walletServiceImpl = walletServiceImpl;
    }


    @PostMapping("/addwallet")
    ResponseEntity<Wallet> addNewWallet(@RequestBody WalletDTO newWallet) throws AccountAlreadyExistsEx {
        Optional<Wallet> walletDTO = Optional.ofNullable(walletServiceImpl.findByuuid(newWallet.getUuid()).orElse(null));
        if (walletDTO.isEmpty()) {
            walletServiceImpl.save(newWallet.converterToDAO());
        } else {
            if (walletDTO.get().converterToDTO().getUuid().compareTo(newWallet.getUuid()) == 0)
                throw new AccountAlreadyExistsEx("Account with UUID " + newWallet.getUuid() + " already exists ");
        }
        return new ResponseEntity<>(newWallet.converterToDAO(), HttpStatus.CREATED);
    }


    @GetMapping("/wallets/{walletId}")
    ResponseEntity<Wallet> wallet(@PathVariable UUID walletId) throws AccountNotFoundEx {
        WalletDTO walletDTO = walletServiceImpl.findByuuid(walletId).orElseThrow(() -> new AccountNotFoundEx("Account with UUID: " + walletId + " was not found")).converterToDTO();
        return new ResponseEntity<>(walletDTO.converterToDAO(), HttpStatus.OK);
    }


    @PutMapping("/wallet")
    Wallet newWallet(@RequestBody WalletDTO newWalletDTO) throws AccountNotFoundEx, BadQueryEx, BalanceNotEnoughEx {
        return walletServiceImpl.updateExistWallet(newWalletDTO);
    }


    @GetMapping("/wallets")
    List<Wallet> getAllWallets() {
        return walletServiceImpl.findAll();
    }


}
