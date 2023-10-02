package com.br.fiap.proposal;

import com.br.fiap.proposal.controller.exception.ProductAndSubProductNotFoundException;
import com.br.fiap.proposal.dto.ProposalRequestDTO;
import com.br.fiap.proposal.dto.ProposalResponseDTO;
import com.br.fiap.proposal.service.ProductAndSubProductService;
import com.br.fiap.proposal.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProposalUseCase {

    @Autowired
    private ProductAndSubProductService productAndSubProductService;

    @Autowired
    private ProposalService proposalService;

    public ProposalResponseDTO createProposal(ProposalRequestDTO dto) {
        boolean exist = productAndSubProductService
                .isProductAndSubProductExists(dto.proposal().productCode(), dto.proposal().subProductCode());

        if (!exist)
            throw new ProductAndSubProductNotFoundException("Product and sub-product not exist!");

        return proposalService.save(dto);
    }
}
