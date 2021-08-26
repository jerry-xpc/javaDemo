package com.java.reflect;

import java.lang.reflect.Field;

public class ReflectField{
    public static void main(String[] args) throws Exception{
        Class<?> c = Class.forName("com.java.reflect.Student");
        Field field = c.getField("age");
        System.out.println("field:"+field);

        Field fields[] = c.getFields();
        for (Field f:fields) {
            System.out.println("f:"+f.getDeclaringClass());
        }

        System.out.println("================getDeclaredFields====================");

        Field fields2[] = c.getDeclaredFields();
        for (Field f:fields2) {
            System.out.println("f2:"+f.getDeclaringClass());
        }

        Field field2 = c.getDeclaredField("desc");
        System.out.println("field2:"+field2);

        System.out.println("===========================================================");

        Class<?> clazz = Class.forName("com.java.reflect.Student");
        Student student = (Student) clazz.newInstance();
        Field f1 = clazz.getField("age");
        f1.set(student,18);

        Field f2 = clazz.getField("name");
        f2.set(student,"xing");

        Field f3 = clazz.getDeclaredField("desc");
        f3.set(student,"I am Student");

        Field f4 = clazz.getDeclaredField("score");
        f4.set(student,98);
        System.out.println(student.toString());

        System.out.println(f4.get(student));
    }
}

class Person{
    public int age;
    public String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class Student extends Person{
    public String desc;

    public int score;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", score=" + score +
                '}';
    }
}