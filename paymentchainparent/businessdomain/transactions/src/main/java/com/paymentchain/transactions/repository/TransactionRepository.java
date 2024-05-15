package com.paymentchain.transactions.repository;

import com.paymentchain.transactions.entities.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Long> {

    @Query("SELECT t from Transactions t WHERE t.accountIban = ?1")
    public List<Transactions> findByIbanAccount(String ibanAccount);
}
