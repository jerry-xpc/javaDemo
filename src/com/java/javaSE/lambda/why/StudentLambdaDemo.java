package com.java.javaSE.lambda.why;

import java.util.ArrayList;
import java.util.List;

public class StudentLambdaDemo {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("zhangSan",12,90));
        list.add(new Student("liSi",15,65));
        list.add(new Student("wangWu",13,70));
        list.add(new Student("maLiu",14,88));
        list.add(new Student("liuQi",11,92));

        getByFilter(list,(e)->e.getAge() > 14);
        System.out.println("=====================");
        getByFilter(list,(a)->a.getScore() > 85);
        System.out.println("=====================");
        getByFilter(list,(b)->b.getName().length()>6);
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
