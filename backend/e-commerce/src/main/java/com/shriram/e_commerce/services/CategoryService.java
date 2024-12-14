package com.shriram.e_commerce.services;

import com.shriram.e_commerce.dto.request.CategoryDtoRequest;
import com.shriram.e_commerce.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    boolean registerNewCategory(CategoryDtoRequest categoryRequest);

    List<String> getAllCategoriesName();

    List<CategoryResponse> getAllCategoriesNameAndImg();
}
