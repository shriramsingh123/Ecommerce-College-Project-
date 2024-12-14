package com.shriram.e_commerce.services;

import com.shriram.e_commerce.dto.request.OrderDtoRequest;
import com.shriram.e_commerce.dto.response.OrdersDtoList;

import java.util.List;

public interface OrderService {
    void placeOrder(OrderDtoRequest orderDtoRequest);

    List<OrdersDtoList> getOrdersList(int user_Id);
}
