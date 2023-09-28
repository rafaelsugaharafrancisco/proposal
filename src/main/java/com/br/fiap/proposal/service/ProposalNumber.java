package com.br.fiap.proposal.service;

import com.br.fiap.proposal.reopsitory.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

public class ProposalNumber {

    private ProposalRepository proposalRepository;

    public ProposalNumber(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }

    protected String create(String bankCode, String agencyCode, int year) {

        String maxNumber = proposalRepository.getMaxNumber(bankCode, agencyCode, year);

        if (maxNumber == null) {
            return "00000001";
        }

        int proposalNumber = Integer.valueOf(maxNumber);
        proposalNumber ++;

        DecimalFormat decimalFormat = new DecimalFormat("00000000");

        return decimalFormat.format(proposalNumber);
    }
}
