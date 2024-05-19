package com.example.testtaskjavacode.controller;

import com.example.testtaskjavacode.DAO.Wallet;
import com.example.testtaskjavacode.DTO.WalletDTO;
import com.example.testtaskjavacode.exception.MyEx;
import com.example.testtaskjavacode.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class WalletController {

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    private WalletService walletService;

    @PostMapping("/wallet")
    Wallet newWallet(@RequestBody Wallet newWallet) {
        return walletService.save(newWallet);

    }


    @PutMapping("/wallets/{valetId}")
    Wallet newWallet(@RequestBody WalletDTO newWalletDTO, @PathVariable UUID valetId) throws MyEx, MyEx {
        return walletService.updateExistWallet(newWalletDTO, valetId);

    }


    @GetMapping("/wallets")
    List<Wallet> getAllWallets() {
        return walletService.findAll();
    }

    @GetMapping("/wallet/{valetId}")
    Wallet wallet(@PathVariable UUID valetId) {
        return walletService.findByuuid(valetId).converterToDAO();

    }


}
