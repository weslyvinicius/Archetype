package org.archetype_project.persistence.util;

import org.archetype_project.domain.Product;
import org.archetype_project.entity.ProductEntity;

public class MocksBeans {

    public static Product createBeanProduc(){
        return Product.builder()
                .title("iPhone 10")
                .description("An apple mobile which is nothing like apple")
                .build();
    }

    public static ProductEntity createBeanProducEntity(){
        return ProductEntity.builder()
                .id(1L)
                .title("iPhone 10")
                .description("An apple mobile which is nothing like apple")
                .build();
    }

}
