package com.shriram.e_commerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shriram.e_commerce.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date date;

    private int amount;

    @Column(length = 20)
    private String payment;

    private OrderStatus orderStatus;

    private int totalAmount;

    private int discount = 0;

    private UUID trackingId;

    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "address_id",nullable = false)
    private Address address;

    private int userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

//    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
    @ElementCollection
    @CollectionTable(name = "order_carts",joinColumns = @JoinColumn(name = "order_id"))
    private List<Carts> cartsList;
}
