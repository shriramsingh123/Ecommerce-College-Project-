package com.shriram.e_commerce.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

<<<<<<< HEAD
    @Column(length = 20)
    private String email;
    @Column(length = 20)
    private String firstName;
    @Column(length = 20)
    private String lastName;
    @Column(length = 20)
    private String country;
    @Column(length = 20)
    private String province;
    @Column(length = 20)
    private String city;
    @Column(length = 20)
    private String street;
    @Column(length = 20)
    private String postalCode;
    @Column(length = 20)
=======
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
>>>>>>> c6bd71b (updated cards in frontend)
    private String mobileNo;
}
