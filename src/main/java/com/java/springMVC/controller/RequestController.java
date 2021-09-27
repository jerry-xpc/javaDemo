package com.java.springMVC.controller;

import com.java.springMVC.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Map;

@Controller
@SessionAttributes(value ={"userName","request"} )
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

    @RequestMapping("/testResponseMap")
    public String testResponseMap(Map<String,String> map){
        map.put("request","testRequestMap");
        map.put("session","testRequestMap");
        return "hello";
    }

    @RequestMapping("/testResponseModel")
    public String testResponseModel(Model model){
        model.addAttribute("request","testResponseModel");
        model.addAttribute("session","testResponseModel");
        return "hello";
    }

    @RequestMapping("/testResponseModelMap")
    public String testResponseModelMap(ModelMap map){
        map.addAttribute("request","testRespnoseModelMap");
        map.addAttribute("session","testRespnoseModelMap");
        return "hello";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("request","testModelAndView");
        modelAndView.addObject("session","testModelAndView");
        return modelAndView;
    }

    @RequestMapping("/testSession")
    public String testSession(Model model){
        model.addAttribute("userName","testSession");
        return "hello";
    }
}
