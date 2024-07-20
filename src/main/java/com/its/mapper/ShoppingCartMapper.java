package com.its.mapper;

import com.its.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {

    int add(ShoppingCart shoppingCart);

    ShoppingCart selectByUserIdAndProductId(ShoppingCart shoppingCart);

    int updateById(@Param("cartId") int cartId, @Param("quantity") int quantity);

    List<ShoppingCart> selectAllByUserId(int userId);

}
