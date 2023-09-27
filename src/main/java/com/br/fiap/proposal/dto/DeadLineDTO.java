package com.br.fiap.proposal.dto;

import com.br.fiap.proposal.entity.AmountType;

public record DeadLineDTO(AmountType amountType, Integer amount) {
}
