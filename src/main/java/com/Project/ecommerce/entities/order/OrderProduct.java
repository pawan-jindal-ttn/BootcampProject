package com.Project.ecommerce.entities.order;

import com.Project.ecommerce.entities.product.ProductVariation;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Integer quantity;
    private Long price;

    @ManyToOne
    private OrderName orderName;

    @ManyToOne
    private ProductVariation productVariation;

    @OneToMany(mappedBy = "orderProduct")
    private List<OrderStatus> orderStatuses;
}
