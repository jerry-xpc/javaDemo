package com.java.javaSE.lambda.who;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaTest {
    public static void main(String[] args) throws Exception {
        //通过内部类的方式创建接口对象
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable1----------------");
            }
        };
        runnable1.run();

        //使用lambda表达式1
        Runnable runnable2 = ()->{
            System.out.println("runnable2-------------");
        };
        runnable2.run();

        //使用lambda表达式2
        Runnable runnable3 = ()-> System.out.println("runnable3----------------");
        runnable3.run();

        Callable<String> callable1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "callable1----------";
            }
        };
        System.out.println(callable1.call());

        Callable<String> callable2 = ()->{
            return "callable2--------";
        };
        System.out.println(callable2.call());

        Callable<String> callable3 = ()->"callable3----------";
        System.out.println(callable3.call());

        StudentDao studentDao = new StudentDao() {
            @Override
            public void insert(Student student) {
                System.out.println("嗨！你好啊同学");
            }
        };

        StudentDao studentDao1 = (Student student)->{
            System.out.println("studentDao1:"+student);
        };

        StudentDao studentDao2 = (student)-> System.out.println("studentDao2:"+student);

        studentDao.insert(new Student());
        studentDao1.insert(new Student());
        studentDao2.insert(new Student());

        TeacherDao teacherDao = new TeacherDao() {
            @Override
            public int get(Teacher teacher) {
                return 1;
            }
        };

        TeacherDao teacherDao1 = (Teacher teacher)->{
            return 2;
        };

        TeacherDao teacherDao2 = (teacher)->{
            return 3;
        };

        TeacherDao teacherDao3 = (teacher)->4;
        TeacherDao teacherDao4 = (Teacher teacher)->5;

        System.out.println(teacherDao.get(new Teacher()));
        System.out.println(teacherDao1.get(new Teacher()));
        System.out.println(teacherDao2.get(new Teacher()));
        System.out.println(teacherDao3.get(new Teacher()));
        System.out.println(teacherDao4.get(new Teacher()));

        //在Java中提供了一系列的函数式接口，用来接受后续传入的逻辑，但是对输入和输出有要求
        Function<String,Integer> function = (str)->{
            return str.length();
        };
        System.out.println(function.apply("xingpc001"));


        Supplier<String> supplier = ()->{
            return "mashibing";
        };

        Supplier<String> supplier1 = ()->"马士兵";
        System.out.println(supplier.get());
        System.out.println(supplier1.get());

        //两个输入参数一个输出参数，所以在表达式的时候只需要传入两个输入参数即可
        BiFunction<String,String,Integer> biFunction = (a,b)->a.length()+b.length();
        System.out.println(biFunction.apply("xingpc001","马士兵"));

        Runnable r = ()->get();
        Runnable r1 = ()->find();
        Runnable r2 = ()->exec();
        r.run();
        r1.run();
        r2.run();

        LamabdInterface l1 = ()->get();
        System.out.println(l1.get());

        LamabdInterface l2 = ()->100;
        System.out.println(l2.get());

        LamabdInterface L3 = ()->true?1:2;

        List<String> list = Arrays.asList("a","b","c");
        list.forEach(System.out::println);
    }

    static int get(){
        return 1;
    }

    static String find(){
        return "find";
    }

    static void exec(){
        find();
    }
}
