package org.archetype_project.integration;

import lombok.AllArgsConstructor;
import org.archetype_project.domain.Product;
import org.archetype_project.feign.DummyjsonFeignClient;
import org.archetype_project.mappers.ProductClientsMapper;
import org.archetype_project.ports.out.IUseCaseIntegrationDummyAPI;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UseCaseIntegrationDummyAPI implements IUseCaseIntegrationDummyAPI {

    private DummyjsonFeignClient dummyjsonFeignClient;
    private ProductClientsMapper productClientsMapper;
    @Override
    public List<Product> getProductDummy() {
        return productClientsMapper.toProductList(dummyjsonFeignClient.getProcuts());
    }
}
