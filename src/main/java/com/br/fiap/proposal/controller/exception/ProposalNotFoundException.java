package com.br.fiap.proposal.controller.exception;

public class ProposalNotFoundException extends RuntimeException {

    public ProposalNotFoundException(String message) {
        super(message);
    }
}
