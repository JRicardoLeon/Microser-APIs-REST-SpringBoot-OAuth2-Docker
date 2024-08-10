package com.paymentchain.customer.repository;

import com.paymentchain.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c from Customer c WHERE c.code = ?1")
    public  Customer findByCode(String code);

    @Query("SELECT c from Customer c WHERE c.iban = ?1")
    public  Customer findByAccount(String iban);

}
