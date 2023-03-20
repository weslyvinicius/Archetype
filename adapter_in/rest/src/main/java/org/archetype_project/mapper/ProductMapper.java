package org.archetype_project.mapper;

import org.archetype_project.domain.Product;
import org.archetype_project.presentation.request.ProductRequest;
import org.archetype_project.presentation.response.ProductResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    Product toProduct(ProductRequest productRequest);

    ProductResponse toProductResponse(Product product);

    List<ProductResponse> toProductList(List<Product> productList);


}
