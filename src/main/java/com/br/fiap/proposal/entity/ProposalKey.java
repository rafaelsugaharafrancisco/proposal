package com.br.fiap.proposal.entity;

import com.br.fiap.proposal.service.ProposalNumber;
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

    public ProposalKey() {
    }

    public ProposalKey(String bankCode, String agencyCode, Integer currentYear, String number) {
        bankCodeValidation(bankCode);
        agencyCodeValidation(agencyCode);
        currentYearValidation(currentYear);
        numberValidation(number);
        this.bankCode = bankCode;
        this.agencyCode = agencyCode;
        this.currentYear = currentYear;
        this.number = number;
    }

    public String getBankCode() {
        return bankCode;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public Integer getCurrentYear() {
        return currentYear;
    }

    public String getNumber() {
        return number;
    }



    private void numberValidation(String number) {

        if (number == null || number.isBlank())
            throw new IllegalArgumentException("Invalid bank code! Can't be null or blank.");

        if (number.length() > 8)
            throw new IllegalArgumentException("Invalid proposal number! Can't be greater eight.");
    }

    private void bankCodeValidation(String bankCode) {
        if (bankCode == null || bankCode.isBlank())
            throw new IllegalArgumentException("Invalid bank code! Can't be null or blank.");

        if (bankCode.length() > 4)
            throw new IllegalArgumentException("Invalid bank code! Can't be greater four.");
    }

    private void agencyCodeValidation(String agencyCode) {
        if (agencyCode == null || agencyCode.isBlank())
            throw new IllegalArgumentException("Invalid agency code! Can't be null or blank.");

        if (agencyCode.length() > 4)
            throw new IllegalArgumentException("Invalid agency code! Can't be greater four.");
    }
    private void currentYearValidation(Integer currentYear) {
        if (currentYear == null)
            throw new IllegalArgumentException("Invalid current year! Can't be null.");

        if (currentYear <= 0)
            throw new IllegalArgumentException("Invalid current year! Can't be less than zeros.");
    }

}
