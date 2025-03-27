package com.Project.ecommerce.entities.order;

import com.Project.ecommerce.entities.product.ProductVariation;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int quantity;
    private long price;

    @ManyToOne
    private OrderName orderName;

    @ManyToOne
    private ProductVariation productVariation;
}
