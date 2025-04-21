package com.shriram.e_commerce.dto.response;

import lombok.Data;

@Data
public class CategoryResponse {

    private String categoryName;
    private String categoryDesc;
    private byte[] categoryImg;

}
