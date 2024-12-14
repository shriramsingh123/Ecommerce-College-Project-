package com.shriram.e_commerce.services.impl;

import com.shriram.e_commerce.dto.request.CategoryDtoRequest;
import com.shriram.e_commerce.dto.response.CategoryResponse;
import com.shriram.e_commerce.entity.Category;
import com.shriram.e_commerce.repository.CategoryRepository;
import com.shriram.e_commerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    // create a new category
    @Override
    public boolean registerNewCategory(CategoryDtoRequest categoryRequest) {
        Category category = new Category();
        category.setCategoryName(categoryRequest.getCategoryName());
        category.setCategoryDesc(categoryRequest.getCategoryDesc());
        try{
            category.setCategoryImg(categoryRequest.getCategoryImg().getBytes());
        }catch(IOException exception){
            System.out.println(exception.getMessage());
        }
        categoryRepository.save(category);
        return true;
    }

    @Override
    public List<String> getAllCategoriesName() {
        return categoryRepository.getAllCategoryName();
    }

    @Override
    public List<CategoryResponse> getAllCategoriesNameAndImg() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for (Category category : categories){
            CategoryResponse response = new CategoryResponse();
            response.setCategoryName(category.getCategoryName());
            response.setCategoryImg(category.getCategoryImg());
            categoryResponses.add(response);
        }

        return categoryResponses;
    }


}
