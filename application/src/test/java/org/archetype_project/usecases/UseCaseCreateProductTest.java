package org.archetype_project.usecases;

import org.archetype_project.domain.Product;
import org.archetype_project.ports.out.IUseCaseSaveProduct;
import org.archetype_project.usecases.util.MocksBeans;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UseCaseCreateProductTest {

    @InjectMocks
    UseCaseCreateProduct useCaseCreateProduct;

    @Mock
    private IUseCaseSaveProduct useCaseSaveProduct;

    @Test
    void createProduct() {

        Mockito.when(useCaseSaveProduct.saveProduct(Mockito.any())).thenReturn(MocksBeans.createBeanProductSave());

        Product product = useCaseCreateProduct.createProduct(MocksBeans.createBeanProduct());

        Assertions.assertEquals(1L, product.getId());
        Assertions.assertEquals("iPhone 10", product.getTitle());
        Assertions.assertEquals("An apple mobile which is nothing like apple", product.getDescription());

    }
}