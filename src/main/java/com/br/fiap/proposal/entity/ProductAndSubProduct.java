package com.br.fiap.proposal.entity;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_sub_product")
public class ProductAndSubProduct {

    @EmbeddedId
    private ProductAndSubProductPK productAndSubProductPK;

    @Column(length = 100)
    private String description;

    public ProductAndSubProduct(){}

    protected ProductAndSubProduct(ProductAndSubProductPK productAndSubProductPK, String description) {
        this.productAndSubProductPK = productAndSubProductPK;
        this.description = description;
    }

    public ProductAndSubProductPK getProductAndSubProductPK() {
        return productAndSubProductPK;
    }

    public String getDescription() {
        return description;
    }
}
