package com.shriram.e_commerce.services.impl;

import com.shriram.e_commerce.dto.response.ProductDtoResponse;
import com.shriram.e_commerce.dto.response.WishListDtoResponse;
import com.shriram.e_commerce.entity.Product;
import com.shriram.e_commerce.entity.Users;
import com.shriram.e_commerce.entity.Wishlist;
import com.shriram.e_commerce.repository.ProductRepository;
import com.shriram.e_commerce.repository.UsersRepository;
import com.shriram.e_commerce.repository.WishlistRepository;
import com.shriram.e_commerce.services.WishlistService;
import com.shriram.e_commerce.supports.ConvertsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void addToWishlist(int productId,int userId) {
        Wishlist wishlist = new Wishlist();

        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new RuntimeException("WishList Product Impl Exception"));
        wishlist.setProduct(product);

        Users users = usersRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("WishList user Impl Exception"));
        wishlist.setUsers(users);
        wishlistRepository.save(wishlist);
    }

    @Override
    public List<WishListDtoResponse> getAllProducts(int userId) {
        List<WishListDtoResponse> responseList = new ArrayList<>();
        List<Wishlist> wishlists = wishlistRepository.findAll();
        for (Wishlist wishlist : wishlists){
           if (wishlist.getUsers().getUserId() == userId){
               WishListDtoResponse response = new WishListDtoResponse();
               response.setProductDtoResponse(ConvertsDto
                       .convertProductToResponse(wishlist.getProduct()));
               response.setWishlistId(wishlist.getId());
               responseList.add(response);
           }
        }
        return responseList;
    }

    @Override
    public void removeById(int wishlistId) {
        wishlistRepository.deleteById(wishlistId);
    }
}
