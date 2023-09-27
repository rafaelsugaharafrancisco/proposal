package com.br.fiap.proposal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class DeadLine {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AmountType amountType;
    @Column(length = 3, nullable = false)
    private Integer amount;

    public DeadLine(){}

    public DeadLine(AmountType amountType, Integer amount) {
        this.amountType = amountType;
        this.amount = amount;
    }

    public AmountType getAmountType() {
        return amountType;
    }

    public void setAmountType(AmountType amountType) {
        this.amountType = amountType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
