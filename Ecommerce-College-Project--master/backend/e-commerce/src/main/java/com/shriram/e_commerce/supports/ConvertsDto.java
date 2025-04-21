package com.shriram.e_commerce.supports;

import com.shriram.e_commerce.dto.request.UsersDtoRequest;
import com.shriram.e_commerce.dto.response.ProductDtoResponse;
import com.shriram.e_commerce.dto.response.ProfileDataResponse;
import com.shriram.e_commerce.entity.Product;
import com.shriram.e_commerce.entity.Users;

import java.io.IOException;

public class ConvertsDto {

    public static Users convertUsersDtoRequestToUsers(UsersDtoRequest usersDtoRequest) throws IOException {
        Users users = new Users();
        users.setFirstName(usersDtoRequest.getFirstName());
        users.setLastName(usersDtoRequest.getLastName());
        users.setGender(usersDtoRequest.getGender());
        users.setEmail(usersDtoRequest.getEmail());
        users.setPassword(usersDtoRequest.getPassword());
        users.setRoles(usersDtoRequest.getRoles());
        users.setMobileNo(usersDtoRequest.getMobileNo());
        users.setNationality(usersDtoRequest.getNationality());
        users.setProvince(usersDtoRequest.getProvince());
        users.setProfileImg(usersDtoRequest.getProfileImg().getBytes());
        return users;
    }

    public static ProductDtoResponse convertProductToResponse(Product product){
        ProductDtoResponse response = new ProductDtoResponse();
        response.setProductId(product.getProductId());
        response.setShopName(product.getShopName());
        response.setProductName(product.getProductName());
        response.setCategory(product.getCategory().getCategoryName());
        response.setPrice(product.getPrice());
        response.setDiscounts(product.getDiscounts());
        response.setProduct_desc(product.getProduct_desc());
        response.setProductImg(product.getProductImg());
        return response;
    }

    public static ProfileDataResponse convertUsersToProfileResponse(Users users){
        ProfileDataResponse response = new ProfileDataResponse();
        response.setFirstName(users.getFirstName());
        response.setLastName(users.getLastName());
        response.setRoles(users.getRoles());
        response.setUserId(users.getUserId());
        response.setEmail(users.getEmail());
        response.setGender(users.getGender());
        response.setMobileNo(users.getMobileNo());
        response.setNationality(users.getNationality());
        response.setProvince(users.getProvince());
        response.setProfileImg(users.getProfileImg());
        return response;
    }
}
