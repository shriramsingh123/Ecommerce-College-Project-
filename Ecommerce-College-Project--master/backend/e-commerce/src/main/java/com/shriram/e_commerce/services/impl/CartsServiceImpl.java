package com.shriram.e_commerce.services.impl;

import com.shriram.e_commerce.dto.response.CartsResponse;
import com.shriram.e_commerce.dto.response.ProductDtoResponse;
import com.shriram.e_commerce.entity.Carts;
import com.shriram.e_commerce.entity.Product;
import com.shriram.e_commerce.entity.Users;
import com.shriram.e_commerce.repository.CartsRepository;
import com.shriram.e_commerce.repository.ProductRepository;
import com.shriram.e_commerce.repository.UsersRepository;
import com.shriram.e_commerce.services.CartsService;
import com.shriram.e_commerce.supports.ConvertsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartsServiceImpl implements CartsService {

    @Autowired
    private CartsRepository cartsRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public boolean addToCart(int productId,int userId) {
        Carts carts = new Carts();

        Product product = productRepository.findById(productId)
                .orElseThrow(()->new RuntimeException("Add Product To Cart Error"));
        carts.setProduct(product);

        Users users = usersRepository.findById(userId)
                        .orElseThrow(()-> new RuntimeException("Add User To Cart Error"));
        carts.setUsers(users);

        cartsRepository.save(carts);
        return true;
    }

    @Override
    public List<CartsResponse> getAllCartsProducts(int userId) {
        List<CartsResponse> cartsResponses = new ArrayList<>();
        List<Carts> cartsList = cartsRepository.findAll();
        for (Carts carts : cartsList){
            if (carts.getUsers().getUserId() == userId){
                CartsResponse cartsResponse = new CartsResponse();
                ProductDtoResponse productDtoResponse = ConvertsDto
                        .convertProductToResponse(carts.getProduct());
                cartsResponse.setCartId(carts.getId());
                cartsResponse.setProduct(productDtoResponse);
                cartsResponse.setQuantity(carts.getQuantity());
                cartsResponse.setPrice(carts.getProduct().getPrice() * carts.getQuantity());
                cartsResponses.add(cartsResponse);
            }
        }

        return cartsResponses;
    }

    @Override
    public void removeCartProduct(int cartId) {
        cartsRepository.deleteById(cartId);
    }

    @Override
    public void changeQuantityOfProduct(int cartId, int quantity) {
        Carts carts = cartsRepository.findById(cartId)
                .orElseThrow(()->new RuntimeException("Error while updating the quantity of carts"));
        carts.setQuantity(quantity);
        cartsRepository.save(carts);
    }

}
