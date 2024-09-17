package com.shopcollection.shopcollection.service.cart;

import com.shopcollection.shopcollection.model.Cart;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);

    Long initializeNewCart();


}
