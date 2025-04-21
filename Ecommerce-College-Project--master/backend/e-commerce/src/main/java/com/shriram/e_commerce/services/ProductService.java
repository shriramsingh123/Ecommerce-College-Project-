package com.shriram.e_commerce.services;

import com.shriram.e_commerce.dto.request.ProductDtoRequest;
import com.shriram.e_commerce.dto.response.ProductDtoResponse;

import java.util.List;

public interface ProductService {
    boolean addProducts(ProductDtoRequest productDtoRequest);

    List<ProductDtoResponse> getProductsList();

    ProductDtoResponse findProductById(int productId);

    List<ProductDtoResponse> getSimilarProductsList(String productName);

    void removeProductById(int productId);

    void updateProduct(ProductDtoRequest productDtoRequest);
}
