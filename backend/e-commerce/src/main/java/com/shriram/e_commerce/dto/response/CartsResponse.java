package com.shriram.e_commerce.dto.response;

import lombok.Data;

@Data
public class CartsResponse {

    private int cartId;
    private int quantity;
    private int price;
    private ProductDtoResponse product;
}
