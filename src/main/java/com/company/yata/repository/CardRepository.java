package com.company.yata.repository;

import com.company.yata.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    @Query(value = "select * from card where deleted_at is null and id = :id", nativeQuery = true)
    Optional<Card> findByIdAndDeletedAtIsNull(@Param(value = "id") Integer id);
}
