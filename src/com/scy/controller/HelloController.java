package com.scy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("请求进入hello  有人来了");

        return  "hallo";// return 一个界面
    }

}