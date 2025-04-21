package com.shriram.e_commerce.dto.response;

import com.shriram.e_commerce.enums.OrderStatus;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class OrdersDtoList {

    private int orderId;
    private List<byte[]> images;
    private OrderStatus orderStatus;
    private UUID trackingId;
}
