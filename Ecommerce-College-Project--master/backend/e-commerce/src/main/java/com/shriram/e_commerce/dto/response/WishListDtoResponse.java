package com.shriram.e_commerce.dto.response;

import com.shriram.e_commerce.entity.Product;
import lombok.Data;

@Data
public class WishListDtoResponse {

    private int wishlistId;
    private ProductDtoResponse productDtoResponse;

}
