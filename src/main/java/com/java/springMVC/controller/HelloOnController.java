package com.java.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/ishello")
public class HelloOnController {
    @RequestMapping
    public String ishello(Map<String,String> map){
        map.put("hello","hello,springmvc2");
        return "hello";
    }
}
