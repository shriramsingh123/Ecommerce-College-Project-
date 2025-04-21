package com.shriram.e_commerce.services;

import com.shriram.e_commerce.dto.request.CouponDtoRequest;
import com.shriram.e_commerce.dto.response.CouponDtoResponse;
import com.shriram.e_commerce.dto.response.VerifyCoupon;

import java.util.List;

public interface CouponService {
    boolean addCoupon(CouponDtoRequest couponDtoRequest);

    List<CouponDtoResponse> findAllCoupons();

    VerifyCoupon verifyCoupon(String couponCode);
}
