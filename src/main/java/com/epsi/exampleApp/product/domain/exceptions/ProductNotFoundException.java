package com.epsi.exampleApp.product.domain.exceptions;

import java.util.function.Supplier;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
