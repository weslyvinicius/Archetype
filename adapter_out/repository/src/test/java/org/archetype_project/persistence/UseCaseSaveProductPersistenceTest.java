package org.archetype_project.persistence;

import org.archetype_project.domain.Product;
import org.archetype_project.mappers.ProductEntityMapper;
import org.archetype_project.persistence.util.MocksBeans;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UseCaseSaveProductPersistenceTest {

    @InjectMocks
    private UseCaseSaveProductPersistence useCaseSaveProductPersistence;

    @Mock
    private ProductReposity productReposity;

    @Spy
    private ProductEntityMapper productEntityMapper = Mappers.getMapper(ProductEntityMapper.class);

    @Test
    void saveProduct() {

        Mockito.when(productReposity.save(Mockito.any())).thenReturn(MocksBeans.createBeanProducEntity());

        Product product = useCaseSaveProductPersistence.saveProduct(MocksBeans.createBeanProduc());
        Assertions.assertNotNull(product);
    }
}