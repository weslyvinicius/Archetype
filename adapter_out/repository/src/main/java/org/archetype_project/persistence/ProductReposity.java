package org.archetype_project.persistence;

import org.archetype_project.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReposity extends JpaRepository<ProductEntity, Long> {

}
