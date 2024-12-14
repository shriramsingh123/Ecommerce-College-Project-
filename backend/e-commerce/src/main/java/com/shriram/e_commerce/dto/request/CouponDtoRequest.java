package com.shriram.e_commerce.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class CouponDtoRequest {

    private String couponName;
    private String couponCode;
    private int discounts;
    private Date expirationDate;
}
