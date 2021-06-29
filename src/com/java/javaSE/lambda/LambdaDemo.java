package com.java.javaSE.lambda;

import java.util.*;

public class LambdaDemo {
    public static void main(String[] args) {
        //常规创建线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable----------------");
            }
        });
        thread.start();

        //lambda表达式创建线程
        new Thread(()->{
            System.out.println("runnable2-------------------");
        }).start();

        System.out.println("=================================================");

        //常规list集合列表排序
        List<String> list = Arrays.asList("java","javascript","scala","python");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for (String str : list){
            System.out.println(str);
        }

        System.out.println("=================================================");
        List<String> list1 = Arrays.asList("java","javascript","scala","python");
        //利用lambda表达式排序
        Collections.sort(list1,(a,b)->a.length()-b.length());
        list1.forEach(System.out::println);
    }
}
