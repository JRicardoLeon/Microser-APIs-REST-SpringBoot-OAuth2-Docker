package com.paymentchain.product.controller;

import com.paymentchain.product.entities.Product;
import com.paymentchain.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository roductRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") Long id) {
        if(roductRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(ResponseEntity.badRequest().body("ID NOT FOUNT").getStatusCode());
        }
        return ResponseEntity.ok(roductRepository.findById(id));
        //return customerRepository.findById(id).map(client -> new ResponseEntity<>(client, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/productList")
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(roductRepository.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Product> findAll(@RequestBody Product product){
        return ResponseEntity.ok(roductRepository.save(product));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        if(roductRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(ResponseEntity.badRequest().body("ID NOT FOUNT").getStatusCode());
        }
        roductRepository.deleteById(id);
        return ResponseEntity.ok("Product Delete");
    }
}
