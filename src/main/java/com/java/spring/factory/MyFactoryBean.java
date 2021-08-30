package com.java.spring.factory;

import com.java.spring.bean.Person;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean {
    @Override
    public Person getObject() throws Exception {
        Person person = new Person();
        person.setId(23);
        person.setName("0827");
        person.setGender("男");
        person.setAge(12);
        return person;
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    @Override
    public boolean isSingleton(){
        return false;
    }
}
