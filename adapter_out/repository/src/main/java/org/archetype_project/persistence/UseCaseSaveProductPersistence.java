package org.archetype_project.persistence;

import lombok.AllArgsConstructor;
import org.archetype_project.domain.Product;
import org.archetype_project.mappers.ProductEntityMapper;
import org.archetype_project.ports.contract_out.IUseCaseSaveProduct;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class UseCaseSaveProductPersistence implements IUseCaseSaveProduct {

    private final ProductReposity productReposity;
    private final ProductEntityMapper productEntityMapper;
    public Product saveProduct(Product product) {

        var productEntity = productEntityMapper.toProcuctEntity(product);
        var productSave = productReposity.save(productEntity);
        return productEntityMapper.toProduct(productSave);
    }
}
