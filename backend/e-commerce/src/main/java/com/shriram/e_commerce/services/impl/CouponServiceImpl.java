package com.shriram.e_commerce.services.impl;

import com.shriram.e_commerce.dto.request.CouponDtoRequest;
import com.shriram.e_commerce.dto.response.CouponDtoResponse;
import com.shriram.e_commerce.dto.response.VerifyCoupon;
import com.shriram.e_commerce.entity.Coupon;
import com.shriram.e_commerce.repository.CouponRepository;
import com.shriram.e_commerce.services.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Override
    public boolean addCoupon(CouponDtoRequest couponDtoRequest) {
        Coupon coupon = new Coupon();
        coupon.setCouponName(couponDtoRequest.getCouponName());
        coupon.setCouponCode(couponDtoRequest.getCouponCode());
        coupon.setDiscounts(couponDtoRequest.getDiscounts());
        coupon.setExpirationDate(couponDtoRequest.getExpirationDate());
        couponRepository.save(coupon);
        return true;
    }

    @Override
    public List<CouponDtoResponse> findAllCoupons() {
        List<CouponDtoResponse> couponDtoResponseList = new ArrayList<>();
        List<Coupon> coupons = couponRepository.findAll();
        for (Coupon coupon : coupons){
            CouponDtoResponse response = new CouponDtoResponse();
            response.setCouponId(coupon.getCouponId());
            response.setCouponName(coupon.getCouponName());
            response.setCouponCode(coupon.getCouponCode());
            response.setDiscounts(coupon.getDiscounts());
            response.setExpirationDate(coupon.getExpirationDate());
            couponDtoResponseList.add(response);
        }
        return couponDtoResponseList;
    }

    @Override
    public VerifyCoupon verifyCoupon(String couponCode) {
        Coupon coupon = couponRepository.findByCouponCode(couponCode);
        VerifyCoupon verifyCoupon = new VerifyCoupon();
        if (coupon == null){
            verifyCoupon.setCouponId(-1);
            verifyCoupon.setDiscounts(0);
        }else {
            verifyCoupon.setCouponId(coupon.getCouponId());
            verifyCoupon.setDiscounts(coupon.getDiscounts());
        }
        return verifyCoupon;
    }
}
