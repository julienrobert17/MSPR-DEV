package com.epsi.exampleApp.product.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ProductMemory {
    private int id;
    private String label;
    private int price;
}
