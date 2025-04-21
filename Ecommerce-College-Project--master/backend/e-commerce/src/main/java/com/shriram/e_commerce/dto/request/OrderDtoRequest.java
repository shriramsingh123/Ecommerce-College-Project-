package com.shriram.e_commerce.dto.request;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class OrderDtoRequest {

    private String email;
    private String firstName;
    private String lastName;
    private String country;
    private String province;
    private String city;
    private String street;
    private String postalCode;
    private String mobileNo;
    private String payment;
    private List<Integer> cartId;
    private int couponId;
    private int userId;

}
