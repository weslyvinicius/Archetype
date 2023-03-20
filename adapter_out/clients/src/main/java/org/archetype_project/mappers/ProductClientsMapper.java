package org.archetype_project.mappers;

import org.archetype_project.domain.Product;
import org.archetype_project.doman.response.ProductRecordOutput;
import org.archetype_project.doman.response.ProductsOutput;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductClientsMapper {

    default List<Product> toProductList(ProductsOutput productsOutput){
        return toProduct(productsOutput.getProducts());
    }

    List<Product> toProduct(List<ProductRecordOutput> productOutputList);
}
