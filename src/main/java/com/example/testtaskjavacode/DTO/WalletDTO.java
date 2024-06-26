package com.example.testtaskjavacode.DTO;

import com.example.testtaskjavacode.DAO.Wallet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class WalletDTO {
    private UUID uuid;
    private OperationType operationType;
    private BigDecimal amount;

    public enum OperationType {
        DEPOSIT, WITHDRAW
    }

    public Wallet converterToDAO() {
        Wallet wallet = new Wallet();
        wallet.setUuid(uuid);
        wallet.setAmount(amount);
        return wallet;
    }

}

