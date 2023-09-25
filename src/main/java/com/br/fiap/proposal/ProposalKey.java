package com.br.fiap.proposal;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProposalKey {

    @Column(length = 4, nullable = false)
    private String bankCode;

    @Column(length = 4, nullable = false)
    private String agencyCode;

    @Column(length = 4, nullable = false)
    private Integer currencyYear;

    @Column(length = 8, nullable = false)
    private String number;

    public ProposalKey(){}

    public ProposalKey(String bankCode, String agencyCode, Integer currencyYear, String number) {
        this.bankCode = bankCode;
        this.agencyCode = agencyCode;
        this.currencyYear = currencyYear;
        this.number = number;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public Integer getCurrencyYear() {
        return currencyYear;
    }

    public void setCurrencyYear(Integer year) {
        this.currencyYear = year;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
