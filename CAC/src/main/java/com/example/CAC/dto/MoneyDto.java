package com.example.CAC.dto;

import lombok.Data;

@Data
public class MoneyDto {
    private String name;
    private int received_money;
    private int money_spent;
    private int recommended_money;
}