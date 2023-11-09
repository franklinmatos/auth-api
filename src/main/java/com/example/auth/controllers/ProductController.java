package com.example.auth.controllers;

import com.example.auth.domain.product.Product;
import com.example.auth.domain.product.ProductRequestDTO;
import com.example.auth.domain.product.ProductResponseDTO;
import com.example.auth.repositories.ProductRepository;
import com.example.auth.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> postProduct(@RequestBody @Valid ProductRequestDTO body){
        return service.postProduct(body);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        return service.getAllProducts();
    }
}
