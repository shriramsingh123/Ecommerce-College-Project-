package com.shriram.e_commerce.dto.response;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;

@Data
public class CouponDtoResponse {
    private int couponId;
    private String couponName;
    private String couponCode;
    private int discounts;
    private Date expirationDate;
}
