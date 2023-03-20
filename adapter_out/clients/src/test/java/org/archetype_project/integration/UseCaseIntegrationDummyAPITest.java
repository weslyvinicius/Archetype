package org.archetype_project.integration;

import org.archetype_project.config.JacksonFeignUtils;
import org.archetype_project.domain.Product;
import org.archetype_project.doman.response.ProductsOutput;
import org.archetype_project.feign.DummyjsonFeignClient;
import org.archetype_project.integration.util.TestConstants;
import org.archetype_project.mappers.ProductClientsMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class UseCaseIntegrationDummyAPITest {

    @InjectMocks
    private UseCaseIntegrationDummyAPI useCaseIntegrationDummyAPI;

    @Mock
    private DummyjsonFeignClient dummyjsonFeignClient;

    @Spy
    private ProductClientsMapper productClientsMapper = Mappers.getMapper(ProductClientsMapper.class);

    @Test
    void getProductDummy() throws IOException {

        var productList = JacksonFeignUtils.mapperReader(TestConstants.PRODUCTS_CREATE_RESPONSE, ProductsOutput.class);

        Mockito.when(dummyjsonFeignClient.getProcuts()).thenReturn(productList);
        List<Product> productDummy = useCaseIntegrationDummyAPI.getProductDummy();

        Assertions.assertNotNull(productDummy);


    }
}