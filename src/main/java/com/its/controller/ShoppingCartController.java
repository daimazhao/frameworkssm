package com.its.controller;

import com.its.entity.ShoppingCart;
import com.its.service.ShoppingCartService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/shopCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping("/add")
  //  @ResponseBody
    public String add(ShoppingCart shoppingCart){
        int i = shoppingCartService.add(shoppingCart);
        if (i>0){
            return "redirect:/shopCart/list?userId="+shoppingCart.getUserId();
        }
        return "error";
    }

    @RequestMapping("/list")
    public String list(int userId,Model model){
        List<ShoppingCart> list = shoppingCartService.selectAllByUserId(userId);
        model.addAttribute("list",list);
        return "shoppingcart_list";
    }

}


