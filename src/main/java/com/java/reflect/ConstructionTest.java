package com.java.reflect;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

public class ConstructionTest implements Serializable {
    public static void main(String[] args) throws Exception {
        Class<?>  clazz = null;
        clazz = Class.forName("com.java.reflect.User_A");
        User_A user_a = (User_A) clazz.newInstance();
        user_a.setAge(28);
        user_a.setName("jerryXing");
        System.out.println(user_a);

        System.out.println("=======================");

        Constructor constructor = clazz.getConstructor(String.class);
        User_A user_a1 = (User_A) constructor.newInstance("xingpc001");
        user_a1.setAge(29);
        System.out.println(user_a1);

        System.out.println("========================");

        Constructor constructor1 = clazz.getDeclaredConstructor(int.class,String.class);
        constructor1.setAccessible(true);
        User_A user_a2 = (User_A) constructor1.newInstance(26,"hahahhh");
        System.out.println(user_a2);


        System.out.println("=========================");

        Constructor<?> cons[] = clazz.getDeclaredConstructors();

        for (int i=0;i<cons.length;i++){
            Class<?> c[] = cons[i].getParameterTypes();
            System.out.println("构造函数["+i+"]:"+cons[i].toString() );
            System.out.print("参数类型["+i+"]:(");


            for (int j=0;j<c.length;j++){
                if (j == c.length - 1){
                    System.out.print(c[j].getName());
                }else{
                    System.out.print(c[j].getName() + ",");
                }
            }
            System.out.println(")");
        }

        System.out.println("==========================");

        Constructor cs3 = clazz.getDeclaredConstructor(int.class,String.class);
        System.out.println("-----getDeclaringClass-----");
        Class uclazz = cs3.getDeclaringClass();
        System.out.println("构造方法的类:"+uclazz.getName());

        System.out.println("-----getGenericParameterTypes-----");

        Type[] tps = cs3.getGenericParameterTypes();
        for (Type tp : tps){
            System.out.println("参数名称tp:"+tp);
        }

        System.out.println("-----getParameterTypes-----");


        Class<?> clazzs[] = cs3.getParameterTypes();
        for (Class claz : clazzs){
            System.out.println("参数名称:"+claz.getName());
        }

        System.out.println("-----getName-----");

        System.out.println("getName:"+cs3.getName());

        System.out.println("-----getoGenericString-----");

        System.out.println("getoGenericString():"+cs3.toGenericString());

    }
}

class User_A{
    private int age;
    private String name;

    public User_A(){
        super();
    }

    public User_A(String name){
        super();
        this.name = name;
    }

    private User_A(int age,String name){
        super();
        this.age = age;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "User_A{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}