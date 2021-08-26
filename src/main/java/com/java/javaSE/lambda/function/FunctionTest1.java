package com.java.javaSE.lambda.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class FunctionTest1 {
    public static void main(String[] args) {
        //-----------普通的lambda表达式方式----------------
        //String为入参函数类型
        //Integer为返回参数类型
        Function<String,Integer> f = (str)->{return str.length();};
        System.out.println(f.apply("abcd"));
        //在此当<>中只有一个类型时，表示入参类型无返回值类型
        Consumer<String> consumer = (str)-> System.out.println(str);
        consumer.accept("xingpc001");

        //------------通过类静态方法引用方式执行---------------------

        //同样的<>中只有一个类型时，也有可能是返回值类型无入参类型
        //直接使用一个类的静态方法
        Supplier<String> s = ()->FunctionTest1.put();
        System.out.println(s.get());
        //静态方法引用
        Supplier<String> s2 = FunctionTest1::put;
        System.out.println(s2.get());

        //静态方法引用
        Supplier<String> s3 = Fun::hehe;
        System.out.println(s3.get());

        Consumer<Integer> c1 = FunctionTest1::getSize;
        c1.accept(123);
        Consumer<Integer> c2 = (size)->FunctionTest1.getSize(size);
        c2.accept(1234);

        //通过使用string的toUpperCase方法
        Function<String,String> f1 = (str)->str.toUpperCase();
        //通过使用本类自定义的静态方法
        Function<String,String> f2 = (str)->FunctionTest1.toUpperCase(str);
        //使用静态方法引用
        Function<String,String> f3 = FunctionTest1::toUpperCase;
        //使用静态方法引用
        Function<String,String> f4 = Fun::toUpperCase;
        System.out.println(f1.apply("xingpc001"));
        System.out.println(f2.apply("xingpc001"));
        System.out.println(f3.apply("xingpc001"));
        System.out.println(f4.apply("xingpc001"));
        //通过string的自带方法执行
        BiFunction<String,String,Integer> bf1 = (a,b)->a.length()+b.length();
        //通过静态方法引用执行
        BiFunction<String,String,Integer> bf2 = FunctionTest1::getLength;
        System.out.println(bf1.apply("xingpc001", "mashibing"));
        System.out.println(bf2.apply("xingpc001", "mashibing"));

        //------------通过实例方法引用执行------------------------

        System.out.println(new FunctionTest1().put1());
        Supplier<String> supplier1 = ()->new FunctionTest1().put1();
        Supplier<String> supplier2 = ()->{return new FunctionTest1().put1();};
        Supplier<String> supplier3 = new FunctionTest1()::put1;
        System.out.println(supplier1.get());
        System.out.println(supplier2.get());
        System.out.println(supplier3.get());

        FunctionTest1 functionTest1 = new FunctionTest1();
        Consumer<Integer> consumer1 = (size)->new FunctionTest1().getSize1(size);
        Consumer<Integer> consumer2 = new FunctionTest1()::getSize1;
        Consumer<Integer> consumer3 = functionTest1::getSize1;
        consumer1.accept(12345);
        consumer2.accept(12345);
        consumer3.accept(12345);

        Function<String,String> fu1 = (str)->str.toUpperCase();
        Function<String,String> fu2 = (str)->functionTest1.toUpperCase1(str);
        Function<String,String> fu3 = new FunctionTest1()::toUpperCase1;
        Function<String,String> fu4 = functionTest1::toUpperCase1;
        System.out.println(fu1.apply("xingpc001"));
        System.out.println(fu2.apply("xingpc001"));
        System.out.println(fu3.apply("xingpc001"));
        System.out.println(fu4.apply("xingpc001"));

        //---------------对象方法引用------------------

        Consumer<Too> co1 = (Too too)->new Too().foo();
        co1.accept(new Too());
        Consumer<Too> co2 = Too::foo;
        co2.accept(new Too());

        BiConsumer<Too2,String> bc1 = (too2, str) -> new Too2().show(str);
        BiConsumer<Too2,String> bc2 = Too2::show;
        bc1.accept(new Too2(),"ABC");
        bc1.accept(new Too2(),"xingpc001");

        BiFunction<Exec,String,Integer> bif1 = (a,b)->new Exec().test(b);
        BiFunction<Exec,String,Integer> bif2 = Exec::test;
        System.out.println(bif1.apply(new Exec(), "ABC"));
        System.out.println(bif2.apply(new Exec(), "xingpc001"));

        //-------------构造方法引用---------------

        Supplier<Person> su1 = ()->new Person();
        su1.get();
        Supplier<Person> su2 = Person::new;
        su2.get();

        Supplier<List> su3 = ArrayList::new;
        Supplier<Thread> su4 = Thread::new;
        Supplier<String> su5 = String::new;

        Consumer<Integer> ci1 = (age)->new Account(age);
        Consumer<Integer> ci2 = Account::new;
        ci1.accept(12);
        ci2.accept(13);

        Function<String,Account> ff1 = (str)->new Account(str);
        Function<String,Account> ff2 = Account::new;
        ff1.apply("xingpc001");
        ff2.apply("xingpc001");
    }

    public static String put(){
        System.out.println("put---------------");
        return "put";
    }

    public String put1(){
        return "put";
    }

    public static void getSize(int size){
        System.out.println("size:"+size);
    }

    public void getSize1(int size){
        System.out.println("size:"+size);
    }

    public static String toUpperCase(String str){
        return str.toUpperCase();
    }

    public String toUpperCase1(String str){
        return str.toUpperCase();
    }

    public static Integer getLength(String str,String st){
        return str.length()+st.length();
    }

    public Integer getLength1(String str,String st){
        return str.length()+st.length();
    }
}

class Fun{
    public static String hehe(){
        return "hehe";
    }

    public static String toUpperCase(String str){
        return str.toUpperCase();
    }
}

class Exec{
    public Integer test(String s){
        return 1;
    }
}

class Too{
    public Integer fun(String s){
        return 1;
    }

    public void foo(){
        System.out.println("foo");
    }
}

class Too2{
    public Integer fun(String s){
        return 1;
    }
    public void foo(){
        System.out.println("foo---too2");
    }

    public void show(String str){
        System.out.println("show ---too2"+str);
    }
}

class Account{
    public Account(){
        System.out.println("调用无参构造方法");
    }

    public Account(int age){
        System.out.println("age 参数构造" +age);
    }

    public Account(String str){
        System.out.println("str 参数构造" +str);
    }
}

class Person{
    public Person(){
        System.out.println("调用无参的构造方法");
    }
}