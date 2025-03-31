package com.Project.ecommerce.entities.product;

import com.Project.ecommerce.entities.cart.Cart;
import com.Project.ecommerce.entities.order.OrderProduct;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Integer quantityAvailable;
    private Long price;
    private String metaData;
    private String primaryImageName;
    private Boolean isActive;

    @ManyToOne
    Product product;

    @OneToMany(mappedBy = "productVariation")
    private List<Cart> carts;

    @OneToMany(mappedBy = "productVariation")
    private List<OrderProduct> orderProducts;
}
