package com.shriram.e_commerce.controller;

import com.shriram.e_commerce.dto.response.WishListDtoResponse;
import com.shriram.e_commerce.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping("/add/{productId}/{userId}")
    public ResponseEntity<HttpStatus> addProductToWishlist(@PathVariable int productId,
                                                           @PathVariable int userId){
        wishlistService.addToWishlist(productId,userId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<WishListDtoResponse>> getAllWishlistProduct(@PathVariable int userId){
        List<WishListDtoResponse> wishlists = wishlistService.getAllProducts(userId);
        return new ResponseEntity<>(wishlists,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{wishlistId}")
    public ResponseEntity<HttpStatus> removeProductFromWishList(@PathVariable int wishlistId){
        wishlistService.removeById(wishlistId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
