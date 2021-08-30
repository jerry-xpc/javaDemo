package com.java.spring.factory;

import com.java.spring.bean.Person;

public class PersonStaticFactory {
    public static Person getInstance(String name){
        Person person = new Person();
        person.setId(212);
        person.setAge(121);
        person.setName(name);
        person.setGender("女");
        return person;
    }
}
