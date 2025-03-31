package com.Project.ecommerce.entities.order;

import com.Project.ecommerce.entities.user.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderName {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Long amountPaid;
    private Date dateCreated;
    private String paymentMethod;
    private String customerAddressCity;
    private String customerAddressState;
    private String customerAddressCountry;
    private String customerAddressAddressLine;
    private String customerAddressZipCode;
    private String customerAddressLabel;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "orderName")
    private List<OrderProduct> orderProducts;
}