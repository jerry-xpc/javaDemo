package com.java.javaSE.lambda.why;

import java.util.ArrayList;

public class StudentFilterTestDemo1 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("zhangsan",14,67));
        list.add(new Student("lisi",13,89));
        list.add(new Student("wangwu",15,97));
        list.add(new Student("maliu",12,63));
        list.add(new Student("zhaoqi",17,75));

        getByFilter(list, new StudentFilter() {
            @Override
            public boolean compare(Student student) {
                return student.getAge() >13;
            }
        });
        System.out.println("=================================");

        getByFilter(list, new StudentFilter() {
            @Override
            public boolean compare(Student student) {
                return student.getScore() > 85;
            }
        });

        System.out.println("===================================");

        getByFilter(list, new StudentFilter() {
            @Override
            public boolean compare(Student student) {
                return student.getName().length() > 5;
            }
        });
    }

    public static void getByFilter(ArrayList<Student> studentArrayList,StudentFilter studentFilter){
        ArrayList<Student> arrayList = new ArrayList<>();
        for (Student student : studentArrayList){
            if (studentFilter.compare(student)){
                arrayList.add(student);
            }
        }
        printStudent(arrayList);
    }

    public static void printStudent(ArrayList<Student> students){
        for (Student student : students){
            System.out.println(student);
        }
    }
}
