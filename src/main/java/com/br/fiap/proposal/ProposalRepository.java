package com.br.fiap.proposal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, ProposalKey> {

    @Query("SELECT MAX(p.proposalKey.number) " +
            "FROM Proposal p " +
            "WHERE p.proposalKey.bankCode = ?1 " +
            "AND p.proposalKey.agencyCode = ?2 " +
            "AND p.proposalKey.currencyYear = ?3")
    String getMaxNumber(String bankCode, String agencyCode, int year);

//    @Query("SELECT p " +
//            "FROM Proposal p " +
//            "WHERE p.proposalKey.bankCode = ?1 " +
//            "AND p.proposalKey.agencyCode = ?2 " +
//            "AND p.proposalKey.currencyYear = ?3 " +
//            "AND p.proposalKey.number = ?4")
//    Optional<Proposal> findById(String bankCode, String agencyCode, int year, String number);
}
