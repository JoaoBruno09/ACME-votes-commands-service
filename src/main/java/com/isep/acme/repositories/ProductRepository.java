package com.isep.acme.repositories;

import com.isep.acme.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByDesignation(String designation);

    Optional<Product> findBySku(String sku);

    //Delete the product when given the SKU
    @Transactional
    @Modifying
    @Query("DELETE FROM Product p WHERE p.sku=:sku")
    void deleteBySku(@Param("sku") String sku);

    //Update the product when given the SKU
    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.sku = :sku WHERE p.sku=:sku")
    Product updateBySku(@Param("sku") String sku);


}

