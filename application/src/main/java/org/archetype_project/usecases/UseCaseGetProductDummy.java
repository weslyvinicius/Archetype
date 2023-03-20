package org.archetype_project.usecases;

import lombok.AllArgsConstructor;
import org.archetype_project.domain.Product;
import org.archetype_project.ports.contract_in.IUseCaseGetProductDummy;
import org.archetype_project.ports.contract_out.IUseCaseIntegrationDummyAPI;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class UseCaseGetProductDummy implements IUseCaseGetProductDummy {

    private IUseCaseIntegrationDummyAPI useCaseIntegrationDummyAPI;

    @Override
    public List<Product> getProductsAPIDummy() {
        return useCaseIntegrationDummyAPI.getProductDummy();
    }
}
