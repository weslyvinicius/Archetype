package org.archetype_project.usecases;

import lombok.AllArgsConstructor;
import org.archetype_project.domain.Product;
import org.archetype_project.ports.contract_in.IUseCaseCreateProduct;
import org.archetype_project.ports.contract_out.IUseCaseSaveProduct;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UseCaseCreateProduct implements IUseCaseCreateProduct {

    private final IUseCaseSaveProduct useCaseSaveProduct;

    @Override
    public Product createProduct(Product product) {
        return useCaseSaveProduct.saveProduct(product);
    }
}
