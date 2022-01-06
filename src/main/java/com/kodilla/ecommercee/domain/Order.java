package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders")
public class Order extends GenericEntity {

    @Column(name = "orderDate")
    private LocalDate orderDate;

    @Column(name = "deliveryDate")
    private LocalDate deliveryDate;

    @Column(name = "finalCost")
    private BigDecimal finalCost;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Item> items = new ArrayList<>();

    @OneToOne(
            targetEntity = Cart.class,
            mappedBy = "order",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "CART_ID")
    private Cart cart;

}