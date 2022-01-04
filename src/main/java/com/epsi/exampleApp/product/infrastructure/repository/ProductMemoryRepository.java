package com.epsi.exampleApp.product.infrastructure.repository;

import com.epsi.exampleApp.product.domain.exceptions.ProductNotFoundException;
import com.epsi.exampleApp.product.domain.model.Product;
import com.epsi.exampleApp.product.domain.repository.ProductRepository;
import com.epsi.exampleApp.product.infrastructure.adapter.ProductMemoryAdapter;
import com.epsi.exampleApp.product.infrastructure.model.ProductMemory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMemoryRepository implements ProductRepository {
    private final List<ProductMemory> products;
    private final ProductMemoryAdapter adapter;

    public ProductMemoryRepository(ProductMemoryAdapter adapter) {
        this.adapter = adapter;
        products = new ArrayList<>();
        products.add(new ProductMemory(1, "Product 1", 15));
        products.add(new ProductMemory(2, "Product 2", 24));
    }

    @Override
    public Product getProduct(int id) throws ProductNotFoundException {
        ProductMemory product = this.products.stream().filter(p -> p.getId() == id).findAny().orElse(null);

        if (product == null) {
            throw new ProductNotFoundException("Product of id " + id + " not found");
        }

        return this.adapter.modelToProduct(product);
    }

    @Override
    public List<Product> getProducts() {
        return this.products.stream().map(this.adapter::modelToProduct).collect(Collectors.toList());
    }
}
