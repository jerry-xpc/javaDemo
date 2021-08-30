package com.java.spring.controller;

import com.java.spring.dao.PersonDao;
import com.java.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {
    @Autowired
    PersonService personService;
    public void save(){
        personService.save();
    }

    @Autowired
    public void test(PersonDao personDao){
        System.out.println("test");
        personDao.update();
    }
}
