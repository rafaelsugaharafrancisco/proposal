package com.br.fiap.proposal.controller.exception;

public class ProductAndSubProductNotFoundException extends RuntimeException {
    public ProductAndSubProductNotFoundException(String message) {
        super(message);
    }
}
