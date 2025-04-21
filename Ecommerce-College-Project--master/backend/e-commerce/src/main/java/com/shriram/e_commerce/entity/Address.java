package com.shriram.e_commerce.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 200)
    private String email;
    @Column(length = 200)
    private String firstName;
    @Column(length = 200)
    private String lastName;
    @Column(length = 200)
    private String country;
    @Column(length = 200)
    private String province;
    @Column(length = 200)
    private String city;
    @Column(length = 200)
    private String street;
    @Column(length = 200)
    private String postalCode;
    @Column(length = 200)
    private String mobileNo;
}
