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
    private Integer currentYear;

    @Column(length = 8, nullable = false)
    private String number;

    public ProposalKey(){}

    public ProposalKey(String bankCode, String agencyCode, Integer currentYear, String number) {
        this.bankCode = bankCode;
        this.agencyCode = agencyCode;
        this.currentYear = currentYear;
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

    public Integer getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(Integer year) {
        this.currentYear = year;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
