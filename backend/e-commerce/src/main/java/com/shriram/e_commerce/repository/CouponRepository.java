package com.shriram.e_commerce.repository;

import com.shriram.e_commerce.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon , Integer> {

    Coupon findByCouponCode(String couponCode);

}
