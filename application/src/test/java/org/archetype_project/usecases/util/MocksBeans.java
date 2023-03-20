package org.archetype_project.usecases.util;

import org.archetype_project.domain.Product;

public class MocksBeans {

    public static Product createBeanProduct(){
        return Product.builder()
                .title("iPhone 10")
                .description("An apple mobile which is nothing like apple")
                .build();
    }

    public static Product createBeanProductSave(){
        return Product.builder()
                .id(1L)
                .title("iPhone 10")
                .description("An apple mobile which is nothing like apple")
                .build();
    }
}
