package com.epsi.exampleApp.product.infrastructure.adapter;

import com.epsi.exampleApp.product.domain.model.Product;
import com.epsi.exampleApp.product.infrastructure.model.ProductMemory;
import org.springframework.stereotype.Service;

@Service
public class ProductMemoryAdapter {
    public Product modelToProduct(ProductMemory productMemory) {
        return new Product(productMemory.getId(), productMemory.getLabel(), productMemory.getPrice());
    }

    public ProductMemory productToModel(Product product) {
        return new ProductMemory(product.getId(), product.getLabel(), product.getPrice());
    }
}
