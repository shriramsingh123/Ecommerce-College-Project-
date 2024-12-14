package com.shriram.e_commerce.dto.request;

import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Data
@ToString
public class CategoryDtoRequest {

    private String categoryName;
    private String categoryDesc;
    private MultipartFile categoryImg;
}
