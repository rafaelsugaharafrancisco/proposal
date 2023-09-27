package com.br.fiap.proposal.dto;

import com.br.fiap.proposal.entity.ProposalType;

import java.time.LocalDate;

public record ProposalDataResponseDTO(
        String bankCode,
        String agencyCode,
        Integer year,
        String number,
        ProposalType type,
        String productCode,
        String subProductCode,
        Double totalValue,
        DeadLineDTO deadLine,
        LocalDate initialDate
) {
}
