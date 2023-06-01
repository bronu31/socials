package com.example.demo.controller;


import com.example.demo.model.Users;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String enterPage(){
        return "/Hello_world";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        Users users=new Users();
        model.addAttribute("user",users);
        return "/register";
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        if (auth!=null) new SecurityContextLogoutHandler().logout(request,response,auth);
        return "redirect:/enter";
    }

    @PostMapping("/hello")
    String saveUser(@ModelAttribute("user") Users users){
        /*users.setFriends(new ArrayList<>());
        users.setFriend_request(new ArrayList<>());
        users.setSubscribers(new ArrayList<>());
        */userService.saveUser(users);
        return "redirect:/hello";
    }


    @GetMapping("/enter")
    public String loginPage(){
        return "/enter";
    }
}
