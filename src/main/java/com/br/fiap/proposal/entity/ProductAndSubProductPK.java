package com.br.fiap.proposal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProductAndSubProductPK {

    @Column(length = 2)
    private String productCode;

    @Column(length = 4)
    private String subProductCode;

    public ProductAndSubProductPK(){}

    public ProductAndSubProductPK(String productCode, String subProductCode) {
        this.productCode = productCode;
        this.subProductCode = subProductCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getSubProductCode() {
        return subProductCode;
    }
}
