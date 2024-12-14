package com.shriram.e_commerce.controller;

import com.shriram.e_commerce.dto.request.OrderDtoRequest;
import com.shriram.e_commerce.dto.response.OrdersDtoList;
import com.shriram.e_commerce.repository.OrderRepository;
import com.shriram.e_commerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place-order/{cartId}/{userId}")
    public ResponseEntity<HttpStatus> placeOrder(@ModelAttribute OrderDtoRequest orderDtoRequest,
                                                 @PathVariable List<Integer> cartId,
                                                 @PathVariable int userId){
        orderDtoRequest.setUserId(userId);
        orderDtoRequest.setCartId(cartId);
        orderService.placeOrder(orderDtoRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/ordersList/{userId}")
    public ResponseEntity<List<OrdersDtoList>> getOrdersList(@PathVariable int userId){
        List<OrdersDtoList> ordersDtoList = orderService.getOrdersList(userId);
        return new ResponseEntity<>(ordersDtoList,HttpStatus.OK);
    }

}
