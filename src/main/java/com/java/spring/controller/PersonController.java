package com.java.spring.controller;

import com.java.spring.dao.PersonDao;
import com.java.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {
    @Autowired
     public PersonService personService;
    public void save(){
        personService.save();
    }

    public void test(PersonDao personDao){
        System.out.println("test");
        personDao.update();
    }
}
