package com.paymentchain.transactions.controller;

import com.paymentchain.transactions.entities.Transactions;
import com.paymentchain.transactions.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions/")
public class TransactionsController {

    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping("/save")
    public ResponseEntity<Transactions> findAll(@RequestBody Transactions transaction){
        return ResponseEntity.ok(transactionRepository.save(transaction));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTarnsaction(@PathVariable("id") Long id) {
        if(transactionRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(ResponseEntity.badRequest().body("ID NOT FOUNT").getStatusCode());
        }
        return ResponseEntity.ok(transactionRepository.findById(id));
        //return customerRepository.findById(id).map(client -> new ResponseEntity<>(client, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/transactionList")
    public ResponseEntity<List<Transactions>> findAll(){
        return ResponseEntity.ok(transactionRepository.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        if(transactionRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(ResponseEntity.badRequest().body("ID NOT FOUNT").getStatusCode());
        }
        transactionRepository.deleteById(id);
        return ResponseEntity.ok("Transaction Delete");
    }
}
