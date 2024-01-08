package com.company.yata.repository;

import com.company.yata.models.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    @Query(value = "select * from users where deleted_at is null and id = :id", nativeQuery = true)
    Optional<Users> findByIdAndDeletedAtIsNull(@Param(value = "id") Integer id);

    Page<Users> findByDeletedAtIsNull(Pageable pageable);

    Optional<Users> findByEmailAndDeletedAtIsNull(String email);

}
