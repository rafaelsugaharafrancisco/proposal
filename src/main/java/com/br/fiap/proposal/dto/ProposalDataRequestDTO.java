package com.br.fiap.proposal.dto;

import com.br.fiap.proposal.entity.AmountType;
import com.br.fiap.proposal.entity.ProposalType;

import java.time.LocalDate;

public record ProposalDataRequestDTO(
        String bankCode,
        String agencyCode,
        Integer year,
        ProposalType type,
        String productCode,
        String subProductCode,
        Double totalValue,
        AmountType amountType,
        Integer amount,
        LocalDate initialDate
) {
}
