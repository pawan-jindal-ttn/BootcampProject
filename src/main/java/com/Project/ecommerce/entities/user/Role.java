package com.Project.ecommerce.entities.user;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String authority;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}