package com.epsi.exampleApp.product.domain.useCases;

import com.epsi.exampleApp.product.domain.model.Product;
import com.epsi.exampleApp.product.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductsUseCase {
    private final ProductRepository repository;

    public GetProductsUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> execute() {
        return this.repository.getProducts();
    }
}
