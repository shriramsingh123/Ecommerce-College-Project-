package com.shriram.e_commerce.services.impl;

import com.shriram.e_commerce.dto.request.OrderDtoRequest;
import com.shriram.e_commerce.dto.response.OrdersDtoList;
import com.shriram.e_commerce.entity.*;
import com.shriram.e_commerce.enums.OrderStatus;
import com.shriram.e_commerce.repository.*;
import com.shriram.e_commerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private CartsRepository cartsRepository;

    @Override
    public void placeOrder(OrderDtoRequest orderDtoRequest) {
        Orders orders = new Orders();
        // Address
        Address address = new Address();
        address.setEmail(orderDtoRequest.getEmail());
        address.setFirstName(orderDtoRequest.getFirstName());
        address.setLastName(orderDtoRequest.getLastName());
        address.setCountry(orderDtoRequest.getCountry());
        address.setProvince(orderDtoRequest.getProvince());
        address.setCity(orderDtoRequest.getCity());
        address.setStreet(orderDtoRequest.getStreet());
        address.setPostalCode(orderDtoRequest.getPostalCode());
        address.setMobileNo(orderDtoRequest.getMobileNo());
        addressRepository.save(address);

        // coupon
        Coupon coupon = null;
        if (orderDtoRequest.getCouponId() != -1) {
            coupon = couponRepository.findById(orderDtoRequest.getCouponId())
                    .orElseThrow(() -> new RuntimeException("Exception in orderService impl coupon"));
            orders.setCoupon(coupon);
            orders.setDiscount(coupon.getDiscounts());
        }

        // cartsList
        List<Carts> cartsList = cartsRepository.findAllById(orderDtoRequest.getCartId());

        orders.setDate(new Date());
        orders.setOrderStatus(OrderStatus.Pending);
        orders.setPayment(orderDtoRequest.getPayment());
        orders.setTotalAmount(totalAmount(cartsList));
        orders.setAmount(amount(coupon,totalAmount(cartsList)));
        orders.setTrackingId(new UUID(5L, 7L));
        orders.setAddress(address);
        orders.setUserId(orderDtoRequest.getUserId());
        orders.setCartsList(cartsList);

        orderRepository.save(orders);
    }

    @Override
    public List<OrdersDtoList> getOrdersList(int user_Id) {
        List<OrdersDtoList> ordersDtoLists = new ArrayList<>();
        List<Orders> orders = orderRepository.findAllByUserId(user_Id);
        for (Orders order : orders){
            OrdersDtoList dtoList = new OrdersDtoList();
            dtoList.setOrderId(order.getId());
            dtoList.setOrderStatus(order.getOrderStatus());
            dtoList.setTrackingId(order.getTrackingId());
            List<Carts> carts = order.getCartsList();
            if (carts != null) {
                List<byte[]> images = new ArrayList<>();
                for (Carts cart : carts) {
                    images.add(cart.getProduct().getProductImg());
                }
                dtoList.setImages(images);
            }
            ordersDtoLists.add(dtoList);
        }
        return ordersDtoLists;
    }

    private int totalAmount(List<Carts> carts){
        int totalPrice = 0;
        for (Carts cart : carts){
           Product product = cart.getProduct();
           totalPrice+= product.getPrice() - ((product.getPrice() * product.getDiscounts()) / 100);
        }
        return totalPrice;
    }

    private int amount(Coupon coupon,int total){
        if (coupon == null) return total;
        else {
            return  total - ((total * coupon.getDiscounts())/100);
        }
    }

}
