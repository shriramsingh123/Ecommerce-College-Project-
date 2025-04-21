package com.shriram.e_commerce.services.impl;

import com.shriram.e_commerce.dto.request.ProductDtoRequest;
import com.shriram.e_commerce.dto.response.ProductDtoResponse;
import com.shriram.e_commerce.entity.Category;
import com.shriram.e_commerce.entity.Product;
import com.shriram.e_commerce.repository.CategoryRepository;
import com.shriram.e_commerce.repository.ProductRepository;
import com.shriram.e_commerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean addProducts(ProductDtoRequest productDtoRequest) {
        Product product = new Product();
        product.setShopName(productDtoRequest.getShopName());
        product.setProductName(productDtoRequest.getProductName());
        product.setPrice(productDtoRequest.getPrice());
        product.setDiscounts(productDtoRequest.getDiscounts());
        product.setProduct_desc(productDtoRequest.getDesc());
        try{
            product.setProductImg(productDtoRequest.getProductImg().getBytes());
        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }

        Category category = categoryRepository.findByCategoryName(productDtoRequest.getCategory());
        product.setCategory(category);
        productRepository.save(product);
        return true;
    }

    @Override
    public List<ProductDtoResponse> getProductsList() {
        List<Product> products = productRepository.findAll();
        List<ProductDtoResponse> productDtoResponses = new ArrayList<>();
        for (Product product : products){
            ProductDtoResponse response = convertProductToResponse(product);
            productDtoResponses.add(response);
        }
        return productDtoResponses;
    }

    @Override
    public ProductDtoResponse findProductById(int productId) {
         Product product = productRepository.findById(productId)
                 .orElseThrow(()-> new RuntimeException("Product Not Found with this id"));
         return convertProductToResponse(product);
    }

    @Override
    public List<ProductDtoResponse> getSimilarProductsList(String productName) {
        List<Product> products = productRepository.findByProductNameContaining(productName);
        List<ProductDtoResponse> productDtoResponses = new ArrayList<>();
        for (Product product : products){
            ProductDtoResponse response = convertProductToResponse(product);
            productDtoResponses.add(response);
        }
        return productDtoResponses;
    }

    @Override
    public void removeProductById(int productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public void updateProduct(ProductDtoRequest productDtoRequest) {
        Product product = productRepository.findById(productDtoRequest.getProductId())
                .orElseThrow(()->new RuntimeException("Product Not Found for update"));
        product.setShopName(productDtoRequest.getShopName());
        product.setProductName(productDtoRequest.getProductName());
        product.setPrice(productDtoRequest.getPrice());
        product.setDiscounts(productDtoRequest.getDiscounts());
        if (productDtoRequest.getDesc() != null)
        product.setProduct_desc(productDtoRequest.getDesc());
        if (product.getProductImg() != null){
            try{
                product.setProductImg(productDtoRequest.getProductImg().getBytes());
            }catch (IOException exception){
                System.out.println(exception.getMessage());
            }
        }
        Category category = categoryRepository.findByCategoryName(productDtoRequest.getCategory());
        product.setCategory(category);
        productRepository.save(product);
    }

    private ProductDtoResponse convertProductToResponse(Product product){
        ProductDtoResponse response = new ProductDtoResponse();
        response.setProductId(product.getProductId());
        response.setShopName(product.getShopName());
        response.setProductName(product.getProductName());
        response.setPrice(product.getPrice());
        response.setDiscounts(product.getDiscounts());
        response.setProduct_desc(product.getProduct_desc());
        response.setProductImg(product.getProductImg());
        response.setCategory(product.getCategory().getCategoryName());
        return response;
    }
}
