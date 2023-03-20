package org.archetype_project.controller;

import lombok.AllArgsConstructor;
import org.archetype_project.contracts.ArchetypeContract;
import org.archetype_project.mapper.ProductMapper;
import org.archetype_project.ports.contract_in.IUseCaseCreateProduct;
import org.archetype_project.ports.contract_in.IUseCaseGetProductDummy;
import org.archetype_project.presentation.request.ProductRequest;
import org.archetype_project.presentation.response.ProductResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ArchetypeController implements ArchetypeContract {

    private final ProductMapper productMapper;

    private final IUseCaseCreateProduct useCaseCreateProduct;
    private final IUseCaseGetProductDummy useCaseGetProductDummy;

    @Override
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        var product = productMapper.toProduct(productRequest);
        return productMapper.toProductResponse(useCaseCreateProduct.createProduct(product));
    }

    public List<ProductResponse> getProductAPI() {
        return productMapper.toProductList(useCaseGetProductDummy.getProductsAPIDummy());
    }
}
