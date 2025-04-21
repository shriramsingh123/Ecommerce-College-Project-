package com.shriram.e_commerce.dto.request;

import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Data
@ToString
public class ProductDtoRequest {

    private int productId;
    private String category;
    private String shopName;
    private String productName;
    private int price;
    private int discounts;
    private String desc;
    MultipartFile productImg;

}
