package com.br.fiap.proposal.dto;

import java.time.LocalDateTime;

public record StandardExceptionDTO(
        LocalDateTime _timeStamp,
        int _statusCode,
        String _error,
        String _description
) {
}
