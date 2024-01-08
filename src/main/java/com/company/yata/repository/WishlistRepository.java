package com.company.yata.repository;

import com.company.yata.models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
    @Query(value = "select * from wishlist where deleted_at is null and id = :id", nativeQuery = true)
    Optional<Wishlist> findByIdAndDeletedAtIsNull(@Param(value = "id") Integer id);
}
