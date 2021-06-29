package com.java.javaSE.lambda.why;

import java.util.ArrayList;
import java.util.List;

public class StudentTestDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("zhangSan",12,90));
        list.add(new Student("liSi",15,65));
        list.add(new Student("wangWu",13,70));
        list.add(new Student("maLiu",14,88));
        list.add(new Student("liuQi",11,92));
        System.out.println("查找年龄大于13岁的同学：");
        findByAge(list);
        System.out.println("查找分数大于85的同学：");
        findByScore(list);
    }

    public static void findByAge(List<Student> studentList){
        List<Student> list = new ArrayList<>();
        for (Student student : studentList){
            if (student.getAge() > 13){
                list.add(student);
            }
        }

        for (Student student : list){
            System.out.println(student.toString());
        }
    }

    public static void findByScore(List<Student> studentList){
        List<Student> list = new ArrayList<>();
        for (Student student : studentList){
            if (student.getScore() > 85){
                list.add(student);
            }
        }

        for (Student student : list){
            System.out.println(student.toString());
        }
    }
}
