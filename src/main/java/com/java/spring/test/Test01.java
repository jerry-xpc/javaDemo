package com.java.spring.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.java.spring.bean.Address;
import com.java.spring.bean.Person;
import com.java.spring.factory.MyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    public static void main(String[] args) throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
//
//        Person person = (Person) context.getBean("person");
//        System.out.println(person);
//
//        Person person2 = context.getBean("person2", Person.class);
//        System.out.println(person2);
//
//        Person person3 = context.getBean("person3", Person.class);
//        System.out.println(person3);
//
//        Person person4 = context.getBean("person4", Person.class);
//        System.out.println(person4);
//
//        Person person5 = context.getBean("person5", Person.class);
//        System.out.println(person5);
//
//        Person person6 = context.getBean("person6", Person.class);
//        System.out.println(person6);

//        Person person7 = context.getBean("person7", Person.class);
//        System.out.println(person7);

//        Person person8 = context.getBean("person8", Person.class);
//        System.out.println(person8);

//        Person person9 = context.getBean("person9", Person.class);
//        System.out.println(person9);

//        Person person10 = context.getBean("person10", Person.class);
//        System.out.println(person10);
//
//        Person person12 = context.getBean("person12", Person.class);
//        System.out.println(person12);
//
//        Address address = context.getBean("address", Address.class);
//        System.out.println(address);
//
//        Person myFactoryBean = context.getBean("myFactoryBean", Person.class);
//        System.out.println(myFactoryBean);

//        Person person13 = context.getBean("person13", Person.class);
//        System.out.println(person13);
//        ((ClassPathXmlApplicationContext)context).close();

        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        long connectCount = dataSource.getConnectCount();
        System.out.println(connectCount);
//        Person person15 = context.getBean("person15", Person.class);
//        System.out.println(person15);

//        Person person16 = context.getBean("person16", Person.class);
//        System.out.println(person16);
    }
}
