package com.shopcollection.shopcollection.service.order;

import com.shopcollection.shopcollection.dto.OrderDto;
import com.shopcollection.shopcollection.model.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);
    List<OrderDto> getUserOrders(Long userId);
}
