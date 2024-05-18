package com.example.testtaskjavacode.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class WalletModel {
    private long valetId;
    private OperationType operationType;
    private BigDecimal amount;

    public enum OperationType
    {
    DEPOSIT, WITHDRAW
    }


}


