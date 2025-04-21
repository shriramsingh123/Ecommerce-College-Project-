package com.shriram.e_commerce.repository;

import com.shriram.e_commerce.dto.response.CategoryResponse;
import com.shriram.e_commerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Query(value = "SELECT categoryName FROM Category")
    List<String> getAllCategoryName();

    Category findByCategoryName(String categoryName);


}
