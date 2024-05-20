package com.example.testtaskjavacode.DAO;

import com.example.testtaskjavacode.DTO.WalletDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Account")
public class Wallet {
    @Id
    @Column(name = "WalletId")
    private UUID uuid;
    @Column(name = "Amount")
    private BigDecimal amount;

    public WalletDTO converterToDTO() {
        WalletDTO walletDTO = new WalletDTO();
        walletDTO.setUuid(uuid);
        walletDTO.setAmount(amount);
        return walletDTO;
    }

}

