package com.example.testtaskjavacode.model;

import com.example.testtaskjavacode.model.WalletModel;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class Wallet {
    @Id
    @GeneratedValue
    private long UUIDl;
    @Column(name = "OperationType")
    private WalletModel.OperationType operationType;
    @Column(name = "amount")
    private BigDecimal amount;



}