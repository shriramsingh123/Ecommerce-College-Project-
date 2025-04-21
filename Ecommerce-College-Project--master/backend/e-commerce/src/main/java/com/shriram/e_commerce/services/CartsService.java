package com.shriram.e_commerce.services;

import com.shriram.e_commerce.dto.request.CartsRequest;
import com.shriram.e_commerce.dto.response.CartsResponse;
import com.shriram.e_commerce.dto.response.ProductDtoResponse;

import java.util.List;

public interface CartsService {
    boolean addToCart(int productId,int userId);

    List<CartsResponse> getAllCartsProducts(int userId);

    void removeCartProduct(int cartId);

    void changeQuantityOfProduct(int cartId, int quantity);
}
