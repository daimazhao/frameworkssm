package com.its.entity;

import lombok.Data;

@Data
public class ShoppingCart {
    private int cartId;
    private int userId;
    private int productId;
    private int quantity;

    private Products products;
}
