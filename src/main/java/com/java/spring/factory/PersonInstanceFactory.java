package com.java.spring.factory;

import com.java.spring.bean.Address;
import com.java.spring.bean.Person;

public class PersonInstanceFactory {
    public Person getInstance(String name){
        Person person = new Person();
        person.setId(111);
        person.setAge(101);
        person.setName(name);
        person.setGender("男");
        return person;
    }

    public Address getAdrress(){
        Address address = new Address();
        address.setProvince("湖南省");
        address.setCity("长沙市");
        address.setTown("逐鹿书院");
        return address;
    }
}
