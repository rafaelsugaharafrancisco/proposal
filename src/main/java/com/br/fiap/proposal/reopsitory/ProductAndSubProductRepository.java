package com.br.fiap.proposal.reopsitory;

import com.br.fiap.proposal.entity.ProductAndSubProduct;
import com.br.fiap.proposal.entity.ProductAndSubProductPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAndSubProductRepository extends JpaRepository<ProductAndSubProduct, ProductAndSubProductPK> {
}
