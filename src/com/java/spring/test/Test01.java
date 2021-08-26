package com.java.spring.test;

import com.java.spring.bean.Persion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");

        Persion person = (Persion) context.getBean("person");
        System.out.println(person);
    }
}
