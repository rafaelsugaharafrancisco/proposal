package com.br.fiap.proposal.service;

import com.br.fiap.proposal.controller.exception.ProposalNotFoundException;
import com.br.fiap.proposal.dto.ProposalRequestDTO;
import com.br.fiap.proposal.dto.ProposalResponseDTO;
import com.br.fiap.proposal.entity.*;
import com.br.fiap.proposal.entity.ProposalBuilder;
import com.br.fiap.proposal.reopsitory.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProposalService {

    @Autowired
    private ProposalRepository proposalRepository;

    public ProposalResponseDTO save(ProposalRequestDTO dto) {

        var proposal = new ProposalBuilder();
        proposal.setBank(dto.proposal().bankCode())
                .setAgency(dto.proposal().agencyCode())
                .setYear(dto.proposal().year())
                .setNumber(new ProposalNumber(
                    this.proposalRepository).create(
                        dto.proposal().bankCode(), dto.proposal().agencyCode(), dto.proposal().year()))
                .setType(dto.proposal().type())
                .setStatus(ProposalStatus.CRIADA)
                .setAmountType(dto.proposal().amountType())
                .setAmount(dto.proposal().amount())
                .setTotalValue(dto.proposal().totalValue())
                .setProductCode(dto.proposal().productCode())
                .setSubProductCode(dto.proposal().subProductCode());

        var proposalCreated = proposalRepository.save(proposal.createProposal());

        return proposalCreated.toProposalResponseDto();
    }

    public ProposalResponseDTO getOne(String bankCode, String agencyCode, int year, String number) {
        var proposal = proposalRepository
                .findById(new ProposalKey(bankCode, agencyCode, year, number))
                .orElseThrow(() -> new ProposalNotFoundException("Proposal not found!"));

        return proposal.toProposalResponseDto();
    }

    public List<ProposalResponseDTO> getList() {
        return Proposal.toListProposalResponseDto(proposalRepository.findAll());
    }
}
