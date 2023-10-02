package com.br.fiap.proposal.controller.exception;

import com.br.fiap.proposal.dto.StandardExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ProposalHandler {

    @ExceptionHandler(ProposalNotFoundException.class)
    public ResponseEntity<StandardExceptionDTO> notFound(ProposalNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new StandardExceptionDTO(
                        LocalDateTime.now(),
                        HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.name(),
                        e.getMessage())
                );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardExceptionDTO> badRequest(HttpMessageNotReadableException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new StandardExceptionDTO(
                        LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        HttpStatus.BAD_REQUEST.name(),
                        e.getMessage())
                );
    }

    @ExceptionHandler(ProductAndSubProductNotFoundException.class)
    public ResponseEntity<StandardExceptionDTO> logicalError(ProductAndSubProductNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new StandardExceptionDTO(
                        LocalDateTime.now(),
                        HttpStatus.UNPROCESSABLE_ENTITY.value(),
                        HttpStatus.UNPROCESSABLE_ENTITY.name(),
                        e.getMessage()
                ));
    }
}
