package com.shriram.e_commerce.controller;

import com.shriram.e_commerce.dto.request.CategoryDtoRequest;
import com.shriram.e_commerce.dto.response.CategoryResponse;
import com.shriram.e_commerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // To create a category
    @PostMapping("/register")
    public ResponseEntity<HttpStatus> createACategory(@ModelAttribute CategoryDtoRequest categoryRequest){
        boolean res = categoryService.registerNewCategory(categoryRequest);
        if (res){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/name")
    public ResponseEntity<List<String>> getAllCategoryName(){
        List<String> categoriesName = categoryService.getAllCategoriesName();
        return new ResponseEntity<>(categoriesName,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryResponse>> getAllCategoryNameAndImg(){
        return new ResponseEntity<>(categoryService.getAllCategoriesNameAndImg(),HttpStatus.OK);
    }


}
