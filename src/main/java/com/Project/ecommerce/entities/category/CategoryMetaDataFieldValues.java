package com.Project.ecommerce.entities.category;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryMetaDataFieldValues {
    private String value;

    //composite key
    @Id
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    //composite key
    @Id
    @ManyToOne
    @JoinColumn(name = "category_metadata_field_id")
    private CategoryMetaDataField categoryMetaDataField;
}