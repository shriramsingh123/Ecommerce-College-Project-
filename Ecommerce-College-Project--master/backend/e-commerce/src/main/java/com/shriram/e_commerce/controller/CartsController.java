package com.shriram.e_commerce.controller;

import com.shriram.e_commerce.dto.response.CartsResponse;
import com.shriram.e_commerce.services.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartsController {

    @Autowired
    private CartsService cartsService;

    @PostMapping("/add/{productId}/{userId}")
    public ResponseEntity<HttpStatus> addToCarts(@PathVariable int productId,
                                                 @PathVariable int userId){
        boolean bool = cartsService.addToCart(productId,userId);
        if (bool){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<CartsResponse>> getAllCartsProduct(@PathVariable int userId){
        List<CartsResponse> cartsResponses = cartsService.getAllCartsProducts(userId);
        return new ResponseEntity<>(cartsResponses,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cartId}")
    public ResponseEntity<HttpStatus> removeProductFromCartList(@PathVariable int cartId){
        cartsService.removeCartProduct(cartId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/quantity/{cartId}/{quantity}")
    public ResponseEntity<HttpStatus> changeProductQuantity(@PathVariable int cartId,
                                                            @PathVariable int quantity){
        cartsService.changeQuantityOfProduct(cartId,quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
