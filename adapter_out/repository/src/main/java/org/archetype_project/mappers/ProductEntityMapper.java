package org.archetype_project.mappers;

import org.archetype_project.domain.Product;
import org.archetype_project.entity.ProductEntity;
import org.mapstruct.Mapper;


@Mapper
public interface ProductEntityMapper {
    ProductEntity toProcuctEntity(Product product);

    Product toProduct(ProductEntity productEntity);
}
