package com.java.javaSE.stream;

import java.util.Date;

public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public static Person build(String name){
        Person person = new Person();
        person.setName(name);
        return person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Deprecated
    public static void show(){
        System.out.println("show");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Person person = new Person();
        show();
        Date date = new Date();
        System.out.println(date.getMinutes());
    }
}
