package com.Project.ecommerce.entities.user;

import com.Project.ecommerce.entities.cart.Cart;
import com.Project.ecommerce.entities.order.OrderName;
import com.Project.ecommerce.entities.product.ProductReview;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.criteria.Order;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User{
    private Long customerContact;

    @OneToMany(mappedBy = "customer")
    private List<ProductReview> productReviews;

    @OneToMany(mappedBy = "customer")
    private List<Cart> carts;

    @OneToMany(mappedBy = "customer")
    private List<OrderName> orderNames;
}
