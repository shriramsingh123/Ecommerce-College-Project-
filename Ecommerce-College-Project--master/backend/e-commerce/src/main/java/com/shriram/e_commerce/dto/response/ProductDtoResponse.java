package com.shriram.e_commerce.dto.response;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductDtoResponse {

    private int productId;
    private int price;
    private int discounts;
    private String category;
    private String shopName;
    private String productName;
    private String product_desc;
    private byte[] productImg;


}
