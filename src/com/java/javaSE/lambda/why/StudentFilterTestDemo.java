package com.java.javaSE.lambda.why;

import com.java.annotation.A;

import java.util.ArrayList;

public class StudentFilterTestDemo {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("zhangsan",14,67));
        list.add(new Student("lisi",13,89));
        list.add(new Student("wangwu",15,97));
        list.add(new Student("maliu",12,63));
        list.add(new Student("zhaoqi",17,75));

        getByFilter(list,new AgeFilter());
        System.out.println("------------------");
        getByFilter(list,new ScoreFilter());
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
