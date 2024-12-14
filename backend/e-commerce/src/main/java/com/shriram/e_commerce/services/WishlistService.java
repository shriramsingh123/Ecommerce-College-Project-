package com.shriram.e_commerce.services;

import com.shriram.e_commerce.dto.response.WishListDtoResponse;

import java.util.List;

public interface WishlistService {
    void addToWishlist(int productId,int userId);

    List<WishListDtoResponse> getAllProducts(int userId);

    void removeById(int wishlist);
}
