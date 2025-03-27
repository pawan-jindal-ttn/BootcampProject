package com.Project.ecommerce.entities.category;

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
public class CategoryMetaDataField {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "categoryMetaDataField")
    private List<CategoryMetaDataFieldValues> fieldValues;
}
