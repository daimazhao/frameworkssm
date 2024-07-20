package com.its.controller;

import com.its.entity.Products;
import com.its.entity.Student;
import com.its.entity.Users;
import com.its.service.ProductService;
import com.its.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController{

    @Autowired
    private UserService userService;
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response){

        //销毁session和cookie
        HttpSession session = request.getSession();
        session.removeAttribute("loggedIn");
        Cookie cookie = new Cookie("loggedIn","false");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/login.jsp";

    }

    @RequestMapping("/login")
//    @ResponseBody
    public String login(String username,String password,HttpServletRequest request,HttpServletResponse response){
        Users users = userService.queryByUsername(username);
        if(users == null){
            return "error";
        }
        if(!users.getPassword().equals(password)){
            return "error";
        }

        //登陆成功
        HttpSession session = request.getSession();
        session.setAttribute("users",users);
        session.setAttribute("loggedIn",true);
        Cookie cookie = new Cookie("loggedIn","true");
        cookie.setMaxAge(60*60);     //有效期1hour
        cookie.setPath("/");
        response.addCookie(cookie);


        return "redirect:/product/list";
    }
}
