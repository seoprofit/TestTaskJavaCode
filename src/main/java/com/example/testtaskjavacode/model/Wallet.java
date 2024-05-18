package com.example.testtaskjavacode.model;

import com.example.testtaskjavacode.model.WalletModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "account")
public class Wallet {
    @Id
    @Column(name = "UUID")
    private long valetId;
    @Column(name = "OperationType")
    private WalletModel.OperationType operationType;
    @Column(name = "amount")
    private BigDecimal amount;



}

