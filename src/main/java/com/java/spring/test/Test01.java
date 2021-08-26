package com.java.spring.test;

import com.java.spring.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");

        Person person = (Person) context.getBean("person");
        System.out.println(person);

        Person person2 = context.getBean("person2", Person.class);
        System.out.println(person2);

        Person person3 = context.getBean("person3", Person.class);
        System.out.println(person3);

        Person person4 = context.getBean("person4", Person.class);
        System.out.println(person4);

        Person person5 = context.getBean("person5", Person.class);
        System.out.println(person5);

        Person person6 = context.getBean("person6", Person.class);
        System.out.println(person6);
    }
}
