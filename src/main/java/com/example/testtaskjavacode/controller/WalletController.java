package com.example.testtaskjavacode.controller;

import com.example.testtaskjavacode.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class WalletController {

    @Autowired
public WalletController (WalletService walletService)
{
    this.walletService = walletService;
}

    private WalletService walletService;

    @GetMapping("/wallet/")
    public String updateWalletBalance(Model model) {
        model.addAttribute("test", walletService.getStr());

        return "wallet";
    }

    @GetMapping("/wallets")
    public String getWalletBalance(Model model) {

        return "wallet";
    }


}
