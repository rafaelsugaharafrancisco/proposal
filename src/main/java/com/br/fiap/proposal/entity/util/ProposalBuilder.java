package com.br.fiap.proposal.entity.util;

import com.br.fiap.proposal.entity.AmountType;
import com.br.fiap.proposal.entity.Proposal;
import com.br.fiap.proposal.entity.ProposalStatus;
import com.br.fiap.proposal.entity.ProposalType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProposalBuilder {
    private String bank;
    private String agency;
    private int year;
    private String number;
    private ProposalType type;
    private ProposalStatus status;
    private String productCode;
    private String subProductCode;
    private Double totalValue;
    private AmountType amountType;
    private int amount;

    public ProposalBuilder setBank(String bank) {
        this.bank = bank;
        return this;
    }

    public ProposalBuilder setAgency(String agency) {
        this.agency = agency;
        return this;
    }

    public ProposalBuilder setYear(int year) {
        this.year = year;
        return this;
    }

    public ProposalBuilder setNumber(String number) {
        this.number = number;
        return this;
    }

    public ProposalBuilder setType(ProposalType type) {
        this.type = type;
        return this;
    }

    public ProposalBuilder setStatus(ProposalStatus status) {
        this.status = status;
        return this;
    }

    public ProposalBuilder setProductCode(String productCode) {
        this.productCode = productCode;
        return this;
    }

    public ProposalBuilder setSubProductCode(String subProductCode) {
        this.subProductCode = subProductCode;
        return this;
    }

    public ProposalBuilder setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public ProposalBuilder setAmountType(AmountType amountType) {
        this.amountType = amountType;
        return this;
    }

    public ProposalBuilder setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public Proposal createProposal() {
        return new Proposal(bank, agency, year, number, type, status, productCode, subProductCode, totalValue, amountType, amount);
    }
}