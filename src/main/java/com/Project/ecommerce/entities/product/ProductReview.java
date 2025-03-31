package com.Project.ecommerce.entities.product;

import com.Project.ecommerce.entities.user.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductReview {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String review;
    private Integer rating;

    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Product product;
}
