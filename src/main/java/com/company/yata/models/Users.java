package com.company.yata.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Integer id;
    private String username;
    private String email;
    private String password;

    @OneToMany(mappedBy = "usersId")
    private Set<Card> cards;

    @OneToMany(mappedBy = "usersId")
    private Set<Basket> baskets;

    @OneToMany(mappedBy = "usersId")
    private Set<Wishlist> wishlists;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

}