package com.epsi.exampleApp.product.domain.useCases;

import com.epsi.exampleApp.product.domain.exceptions.ProductNotFoundException;
import com.epsi.exampleApp.product.domain.model.Product;
import com.epsi.exampleApp.product.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class GetProductUseCase {
    private final ProductRepository repository;

    public GetProductUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    public Product execute(int id) throws ProductNotFoundException {
        return this.repository.getProduct(id);
    }
}
