package com.shriram.e_commerce.controller;

import com.shriram.e_commerce.dto.request.CouponDtoRequest;
import com.shriram.e_commerce.dto.response.CouponDtoResponse;
import com.shriram.e_commerce.dto.response.VerifyCoupon;
import com.shriram.e_commerce.services.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addNewCoupon(@RequestBody CouponDtoRequest couponDtoRequest){
        boolean bool = couponService.addCoupon(couponDtoRequest);
        if (bool){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<CouponDtoResponse>> getAllCoupons(){
        return new ResponseEntity<>(couponService.findAllCoupons(),HttpStatus.OK);
    }

    @GetMapping("/verify/{couponCode}")
    public ResponseEntity<VerifyCoupon> verifyCoupon(@PathVariable String couponCode){
        VerifyCoupon response = couponService.verifyCoupon(couponCode);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
