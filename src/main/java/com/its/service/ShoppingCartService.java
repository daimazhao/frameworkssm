package com.its.service;

import com.its.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    int add(ShoppingCart shoppingCart);

    List<ShoppingCart> selectAllByUserId(int userId);
}
