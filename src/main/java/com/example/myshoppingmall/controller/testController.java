package com.example.myshoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class testController {
    @GetMapping("/main")
    public String testMain(){
        return "/main";
    }

    @GetMapping("/login")
    public String testLogin(){
        return "/member/memberLoginForm";
    }
}
