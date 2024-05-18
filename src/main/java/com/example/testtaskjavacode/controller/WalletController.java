package com.example.testtaskjavacode.controller;

import com.example.testtaskjavacode.model.Wallet;
import com.example.testtaskjavacode.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class WalletController {

    @Autowired
public WalletController (WalletRepository walletRepository)
{
    this.walletRepository=walletRepository;
}

    private WalletRepository walletRepository;

    @PostMapping("/wallet")
    Wallet newWallet (@RequestBody Wallet newWallet) {
    return walletRepository.save(newWallet);

    }


    @PutMapping ("/wallets/{valetId}")
    Wallet newWallet (@RequestBody Wallet newWallet, @PathVariable Long valetId) {
//        return walletRepository.findById(valetId).map(wallet ->
//        {wallet.setAmount(newWallet.getAmount()); return walletRepository.save(wallet);
// });
Wallet wallet = walletRepository.findById(valetId).orElse(null);

if (wallet == null)
        { new FileNotFoundException("gg"); }
else {
            if (wallet.getAmount().intValue() < newWallet.getAmount().intValue())
                newWallet.setAmount(new BigDecimal(100000000));

        }
return walletRepository.save(newWallet);





    }


    @GetMapping("/wallets")
    List<Wallet> getAllWallets () {
        return walletRepository.findAll();
    }

    @GetMapping ("/wallet/{valetId}")
    Optional<Wallet> wallet (@PathVariable Long valetId)
    {
        return walletRepository.findById(valetId);

    }


}
