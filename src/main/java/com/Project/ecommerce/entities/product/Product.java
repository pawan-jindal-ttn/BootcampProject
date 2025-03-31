package com.Project.ecommerce.entities.product;

import com.Project.ecommerce.entities.category.Category;
import com.Project.ecommerce.entities.user.Seller;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String description;
    private Boolean isCancellable;
    private Boolean isReturnable;
    private String brand;
    private Boolean isActive;
    private Boolean isDeleted;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Seller seller;

    @OneToMany(mappedBy = "product")
    private List<ProductVariation> productVariations;

    @OneToMany(mappedBy = "product")
    private List<ProductReview> productReviews;
}
