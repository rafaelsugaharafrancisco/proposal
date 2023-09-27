package com.br.fiap.proposal.service;

import com.br.fiap.proposal.dto.ProposalRequestDTO;
import com.br.fiap.proposal.dto.ProposalResponseDTO;
import com.br.fiap.proposal.entity.*;
import com.br.fiap.proposal.entity.util.ProposalBuilder;
import com.br.fiap.proposal.entity.util.ProposalNumber;
import com.br.fiap.proposal.reopsitory.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
                .setNumber(ProposalNumber.create(proposalRepository.getMaxNumber(
                                dto.proposal().bankCode(),
                                dto.proposal().agencyCode(),
                                dto.proposal().year())))
                .setType(dto.proposal().type())
                .setStatus(ProposalStatus.CRIADA)
                .setAmountType(dto.proposal().deadLine().amountType())
                .setAmount(dto.proposal().deadLine().amount())
                .setTotalValue(dto.proposal().totalValue())
                .setProductCode(dto.proposal().productCode())
                .setSubProductCode(dto.proposal().subProductCode())
                .setInitialDate(dto.proposal().initialDate())
                .setUpdatedDateTime(LocalDateTime.now());

        var proposalCreated = proposalRepository.save(proposal.createProposal());

        return proposalCreated.toProposalResponseDto();
    }

    public ProposalResponseDTO getOne(String bankCode, String agencyCode, int year, String number) {
        var proposal = proposalRepository.findById(new ProposalKey(bankCode, agencyCode, year, number));

        return proposal.get().toProposalResponseDto();
    }

    public List<ProposalResponseDTO> getList() {
        return Proposal.toListProposalResponseDto(proposalRepository.findAll());
    }
}
