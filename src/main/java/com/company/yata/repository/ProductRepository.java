package com.company.yata.repository;

import com.company.yata.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "select * from product where deleted_at is null and id = :id", nativeQuery = true)
    Optional<Product> findByIdAndDeletedAtIsNull(@Param(value = "id") Integer id);
}
