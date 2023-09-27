package com.br.fiap.proposal.controller;

import com.br.fiap.proposal.dto.ProposalRequestDTO;
import com.br.fiap.proposal.dto.ProposalResponseDTO;
import com.br.fiap.proposal.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proposals")
public class ProposalController {

    @Autowired
    private ProposalService proposalService;

    @PostMapping
    public ResponseEntity<ProposalResponseDTO> createProposal(@RequestBody ProposalRequestDTO proposal) {
        return ResponseEntity.status(HttpStatus.CREATED).body(proposalService.save(proposal));
    }

    @GetMapping("/get-one")
    public ResponseEntity<ProposalResponseDTO> getOneProposal(
            @RequestParam("proposalBankCode") String bankCode,
            @RequestParam("proposalAgencyCode") String agencyCode,
            @RequestParam("proposalYear") Integer year,
            @RequestParam("proposalNumber") String number
            ) { return ResponseEntity.ok(proposalService.getOne(bankCode, agencyCode, year, number)); }

    @GetMapping
    public ResponseEntity<List<ProposalResponseDTO>> getProposals() {
        return ResponseEntity.ok(proposalService.getList());
    }
}
