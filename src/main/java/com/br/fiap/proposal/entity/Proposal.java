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

    public Proposal(String bank, String agency, int year, String number, ProposalType type, ProposalStatus status, String productCode, String subProductCode, Double totalValue, AmountType amountType, int amount, LocalDate initialDate, LocalDateTime updatedDateTime) {
        this.proposalKey = new ProposalKey(bank, agency, year, number);
        this.type = type;
        this.status = status;
        this.productCode = productCode;
        this.subProductCode = subProductCode;
        this.totalValue = totalValue;
        this.deadLine = new DeadLine(amountType, amount);
        this.initialDate = initialDate;
        this.updatedDateTime = updatedDateTime;
    }

    public ProposalKey getProposalKey() {
        return proposalKey;
    }

    public void setProposalKey(ProposalKey proposalKey) {
        this.proposalKey = proposalKey;
    }

    public ProposalType getType() {
        return type;
    }

    public void setType(ProposalType type) {
        this.type = type;
    }

    public ProposalStatus getStatus() {
        return status;
    }

    public void setStatus(ProposalStatus status) {
        this.status = status;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getSubProductCode() {
        return subProductCode;
    }

    public void setSubProductCode(String subProductCode) {
        this.subProductCode = subProductCode;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public DeadLine getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(DeadLine deadLine) {
        this.deadLine = deadLine;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
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
