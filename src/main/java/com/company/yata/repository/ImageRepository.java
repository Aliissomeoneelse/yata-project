package com.company.yata.repository;

import com.company.yata.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Query(value = "select * from image where deleted_at is null and id = :id", nativeQuery = true)
    Optional<Image> findByIdAndDeletedAtIsNull(@Param(value = "id") Integer id);

    Set<Image> findAllByIdAndDeletedAtIsNull(Integer id);
}
