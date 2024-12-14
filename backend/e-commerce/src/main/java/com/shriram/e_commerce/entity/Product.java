package com.shriram.e_commerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private int price;
    private int discounts;

    @Column(length = 50)
    private String shopName;

    @Column(length = 50)
    private String productName;

    private String product_desc;

    @Lob
    private byte[] productImg;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "category_Id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

}
