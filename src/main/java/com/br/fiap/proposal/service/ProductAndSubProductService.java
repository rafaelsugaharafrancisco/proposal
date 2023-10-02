package com.br.fiap.proposal.service;

import com.br.fiap.proposal.controller.exception.ProductAndSubProductNotFoundException;
import com.br.fiap.proposal.entity.ProductAndSubProduct;
import com.br.fiap.proposal.entity.ProductAndSubProductPK;
import com.br.fiap.proposal.reopsitory.ProductAndSubProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductAndSubProductService {

    @Autowired
    private ProductAndSubProductRepository repository;

    public boolean isProductAndSubProductExists(String productCode, String subProductCode) {

        return repository
                .findById(new ProductAndSubProductPK(productCode, subProductCode))
                .isPresent();
    }
}
