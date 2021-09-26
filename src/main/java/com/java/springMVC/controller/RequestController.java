package com.java.springMVC.controller;

import com.java.springMVC.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
public class RequestController {
    @RequestMapping("/testRequest")
    public String testRequest(String name){
        System.out.println(name);
        return "hello";
    }

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(value = "username",required = false,defaultValue = "xingpc001") String name){
        System.out.println(name);
        return "hello";
    }

    @RequestMapping("/testRequestHandler")
    public String testRequestHandler(@RequestHeader("User-Agent") String name){
        System.out.println(name);
        return "hello";
    }

    @RequestMapping("/testCookie")
    public String testCookie(@CookieValue("JSESSIONID") String name){
        System.out.println(name);
        return "hello";
    }

    @RequestMapping("/user")
    public String testUser(User user){
        System.out.println(user);
        return "hello";
    }

    @RequestMapping("/testApi")
    public String testApi(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
        request.setAttribute("request","helloRequest");
        session.setAttribute("session","apiSession");
        response.getWriter().write("<p>2222</p>");
        return "hello";
    }
}
