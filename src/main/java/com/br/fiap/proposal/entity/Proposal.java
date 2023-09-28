package com.br.fiap.proposal.entity;

import com.br.fiap.proposal.dto.DeadLineDTO;
import com.br.fiap.proposal.dto.ProposalDataResponseDTO;
import com.br.fiap.proposal.dto.ProposalResponseDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "proposals")
public class Proposal {

    @EmbeddedId
    private ProposalKey proposalKey;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProposalType type;

    @Enumerated(EnumType.STRING)
    private ProposalStatus status;
    @Column(length = 2, nullable = false)
    private String productCode;
    @Column(length = 4, nullable = false)
    private String subProductCode;

    @Column(nullable = false)
    private Double totalValue;

    @Embedded
    private DeadLine deadLine;

    @Column(nullable = false)
    private LocalDate initialDate;

    @Column(nullable = false)
    private LocalDateTime updatedDateTime;

    public Proposal() {
    }

    public Proposal(String bank, String agency, int year, String number, ProposalType type, ProposalStatus status, String productCode, String subProductCode, Double totalValue, AmountType amountType, int amount) {
        this.proposalKey = new ProposalKey(bank, agency, year, number);
        this.type = type;
        this.status = status;
        this.productCode = productCode;
        this.subProductCode = subProductCode;
        this.totalValue = totalValue;
        this.deadLine = new DeadLine(amountType, amount);
        this.initialDate = LocalDate.now();
        this.updatedDateTime = LocalDateTime.now();
    }

    public void setType(ProposalType type) {
        this.type = type;
    }

    public void setStatus(ProposalStatus status) {
        this.status = status;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public void setDeadLine(DeadLine deadLine) {
        this.deadLine = deadLine;
    }

    public ProposalResponseDTO toProposalResponseDto() {
        return new ProposalResponseDTO(
                    new ProposalDataResponseDTO(
                        proposalKey.getBankCode(),
                        proposalKey.getAgencyCode(),
                        proposalKey.getCurrentYear(),
                        proposalKey.getNumber(),
                        type,
                        productCode,
                        subProductCode,
                        totalValue,
                        new DeadLineDTO(deadLine.getAmountType(), deadLine.getAmount()),
                        initialDate
                    )
        );
    }

    public static List<ProposalResponseDTO> toListProposalResponseDto(List<Proposal> proposals) {
        return proposals.stream().map(Proposal::toProposalResponseDto).toList();
    }
}
