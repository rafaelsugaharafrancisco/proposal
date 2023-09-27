package com.br.fiap.proposal;

import com.br.fiap.proposal.entity.*;
import com.br.fiap.proposal.entity.util.ProposalBuilder;
import com.br.fiap.proposal.reopsitory.ProposalRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class CreateProposalTest {

    @Autowired
    private ProposalRepository proposalRepository;

    @Test
    public void createProposal() {
        var proposalBuilder = new ProposalBuilder();
        proposalBuilder.setBank("0033")
                .setAgency("0001")
                .setYear(LocalDate.now().getYear())
                .setNumber("12345678")
                .setStatus(ProposalStatus.CRIADA)
                .setType(ProposalType.PONTUAL_PJ)
                .setInitialDate(LocalDate.now())
                .setProductCode("30")
                .setSubProductCode("2021")
                .setAmountType(AmountType.MESES)
                .setAmount(48)
                .setTotalValue(150000.0)
                .setUpdatedDateTime(LocalDateTime.now());

        proposalRepository.save(proposalBuilder.createProposal());
    }

    @Test
    public void findProposal() {
        var proposalBuilder = new ProposalBuilder();
        proposalBuilder.setBank("0033")
                .setAgency("0001")
                .setYear(LocalDate.now().getYear())
                .setNumber("12345678")
                .setStatus(ProposalStatus.CRIADA)
                .setType(ProposalType.PONTUAL_PJ)
                .setInitialDate(LocalDate.now())
                .setProductCode("30")
                .setSubProductCode("2021")
                .setAmountType(AmountType.MESES)
                .setAmount(48)
                .setTotalValue(150000.0)
                .setUpdatedDateTime(LocalDateTime.now());

        proposalRepository.save(proposalBuilder.createProposal());

        Optional<Proposal> byId = proposalRepository.findById(new ProposalKey("0033", "0001", 2023, "12345678"));

        Assertions.assertTrue(byId.isPresent());

        Optional<Proposal> byId1 = proposalRepository.findById(new ProposalKey("0033", "0002", 2023, "12345678"));

        Assertions.assertFalse(byId1.isPresent());
    }
}
