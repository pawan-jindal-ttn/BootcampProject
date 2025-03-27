package com.Project.ecommerce.entities.category;

import com.Project.ecommerce.entities.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    // self referencing
    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    @OneToMany(mappedBy = "category")
    private List<CategoryMetaDataFieldValues> metadataFieldValues;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
