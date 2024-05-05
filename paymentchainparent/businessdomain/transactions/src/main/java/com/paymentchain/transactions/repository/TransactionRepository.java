package com.paymentchain.transactions.repository;

import com.paymentchain.transactions.entities.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {

}
