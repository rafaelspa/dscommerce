package com.devsuperior.dscommerce.repositories;

import com.devsuperior.dscommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT obj FROM Product obj " +
            "WHERE UPPER(obj.name) LIKE(CONCAT('%',UPPER(:name),'%')) " +
            "ORDER BY obj.id")
    Page<Product> searchByName(String name, Pageable pageable);
}
