package com.shriram.e_commerce.controller;

import com.shriram.e_commerce.dto.request.ProductDtoRequest;
import com.shriram.e_commerce.dto.response.ProductDtoResponse;
import com.shriram.e_commerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addNewProducts(@ModelAttribute ProductDtoRequest productDtoRequest){
        boolean bool = productService.addProducts(productDtoRequest);
        if (bool){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDtoResponse>> getAllProductList(){
        return new ResponseEntity<>(productService.getProductsList(),HttpStatus.OK);
    }

    @GetMapping("/name/{productName}")
    public ResponseEntity<List<ProductDtoResponse>> getSimilarProduct(@PathVariable String productName){
        return new ResponseEntity<>(productService.getSimilarProductsList(productName),HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDtoResponse> getProductDetailsById(@PathVariable int productId){
        return new ResponseEntity<>(productService.findProductById(productId),HttpStatus.OK);
    }

    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<HttpStatus> deleteProductById(@PathVariable int productId){
        productService.removeProductById(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateProduct(@ModelAttribute ProductDtoRequest productDtoRequest){
        productService.updateProduct(productDtoRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
