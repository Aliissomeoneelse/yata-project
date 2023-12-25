package com.company.yata.repository;

import com.company.yata.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "select * from category where deleted_at is null and id = :id", nativeQuery = true)
    Optional<Category> findByIdAndDeletedAtIsNull(@Param(value = "id") Integer id);
}
