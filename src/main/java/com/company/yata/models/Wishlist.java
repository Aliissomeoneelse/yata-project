package com.company.yata.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "wishlist")
public class Wishlist {
    @Id
    @GeneratedValue(generator = "basket_seq")
    @SequenceGenerator(name = "basket_seq", sequenceName = "basket_seq", allocationSize = 1)
    private Integer id;

    @OneToMany(mappedBy = "wishlistId")
    private Set<Product> products;

    @Column(name = "users_id")
    private Integer usersId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
