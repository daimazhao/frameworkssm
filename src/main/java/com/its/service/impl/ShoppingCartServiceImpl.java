package com.its.service.impl;

import com.its.entity.ShoppingCart;
import com.its.mapper.ShoppingCartMapper;
import com.its.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public int add(ShoppingCart shoppingCart) {
        //查询当前用户购物车中是否存在这个商品

        ShoppingCart sc = shoppingCartMapper.selectByUserIdAndProductId(shoppingCart);
        if(sc==null){
            return shoppingCartMapper.add(shoppingCart);
        }else {
            //更新数量
            return shoppingCartMapper.updateById(sc.getCartId(),shoppingCart.getQuantity());
        }

    }

    @Override
    public List<ShoppingCart> selectAllByUserId(int userId) {
        return shoppingCartMapper.selectAllByUserId(userId);
    }
}
