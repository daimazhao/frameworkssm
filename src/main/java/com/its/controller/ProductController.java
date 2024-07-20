package com.its.controller;

import com.its.entity.Products;
import com.its.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public String list(Model model,HttpServletRequest request){
        List<Products> list = productService.selectAll();
        model.addAttribute("list",list);
        HttpSession session = request.getSession();
        if (session.getAttribute("loggedIn")!=null && (Boolean) session.getAttribute("loggedIn")){
            //已经登陆
            return "product_list";
        }else {
            Cookie[] cookies = request.getCookies();
            if(cookies!=null){
                for(Cookie cookie : cookies){
                    if("loggedIn".equals(cookie.getName()) && "true".equals(cookie.getValue())){
                        return "product_list";
                    }
                }
            }
        }
        return "login";
    }

    @RequestMapping("/showDetail")
    public String showDetail(int id,Model model) {
        Products products = productService.queryProductById(id);
        model.addAttribute("products",products);
        return "product_detail";
    }


}
