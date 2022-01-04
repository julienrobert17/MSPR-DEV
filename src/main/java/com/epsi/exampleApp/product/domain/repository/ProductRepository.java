package com.epsi.exampleApp.product.domain.repository;

import com.epsi.exampleApp.product.domain.exceptions.ProductNotFoundException;
import com.epsi.exampleApp.product.domain.model.Product;

import java.util.List;

public interface ProductRepository {
    Product getProduct(int id) throws ProductNotFoundException;

    List<Product> getProducts();
}
