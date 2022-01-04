package com.epsi.exampleApp.product.infrastructure.controller;

import com.epsi.exampleApp.product.domain.exceptions.ProductNotFoundException;
import com.epsi.exampleApp.product.domain.model.Product;
import com.epsi.exampleApp.product.domain.useCases.GetProductUseCase;
import com.epsi.exampleApp.product.domain.useCases.GetProductsUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final GetProductUseCase getProductUseCase;
    private final GetProductsUseCase getProductsUseCase;

    public ProductController(GetProductUseCase getProductUseCase, GetProductsUseCase getProductsUseCase) {
        this.getProductUseCase = getProductUseCase;
        this.getProductsUseCase = getProductsUseCase;
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getProduct(@PathVariable int id) {
        try {
            Product product = this.getProductUseCase.execute(id);

            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getProducts() {
        return new ResponseEntity<>(this.getProductsUseCase.execute(), HttpStatus.OK);
    }
}
