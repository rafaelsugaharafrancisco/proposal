package com.br.fiap.proposal;

import java.time.LocalDate;

public record ProposalDataRequestDTO(
        String bankCode,
        String agencyCode,
        Integer year,
        ProposalType type,
        String productCode,
        String subProductCode,
        Double totalValue,
        DeadLineDTO deadLine,
        LocalDate initialDate
) {
}
