package com.java.jdbc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassAPI {
    public static void main(String[] args) {
        try {
            Class<?> aclass = Class.forName("com.java.jdbc.reflect.Student");
            //获取成员变量，包括子类及父类，同时只能包含公共的方法
            Field[] fields = aclass.getFields();
            for (Field field : fields)
            {
                System.out.println(field);
                System.out.println(field.getName());
                System.out.println(field.getType());
                System.out.println(field.getModifiers());
                System.out.println("-------------------");
            }
            System.out.println("====================");
            //此方法返回的是当前类的所有属性，不仅仅局限于公共访问修饰符，所有的访问修饰符都可以拿到
            Field[] declaredFields = aclass.getDeclaredFields();
            for (Field field : declaredFields)
            {
                System.out.println(field.getName());
            }
            System.out.println("====================");
            //反射在一定程度上破坏了封装性，需要合理使用
            Field address = aclass.getDeclaredField("address");
            //设置该属性是否能被访问，true表示能被访问 false表示不能被访问
            address.setAccessible(true);
            System.out.println(address.getName());
            Object o = aclass.newInstance();
            address.set(o,"深圳市");
            System.out.println(((Student)o).getAddress());
            System.out.println("====================");
            //获取对象的普通方法，包含方法的范围是当前对象及父类对象的所有公共方法
            Method[] methods = aclass.getMethods();
            for (Method method : methods)
            {
                System.out.println(method.getName());
            }
            System.out.println("====================");
            //获取当前类中的所有方法，无论什么修饰符方法
            Method[] declaredMethods = aclass.getDeclaredMethods();
            for (Method method : declaredMethods)
            {
                System.out.println(method.getName());
            }
            System.out.println("====================");
            Method add = aclass.getDeclaredMethod("add", int.class, int.class);
            add.setAccessible(true);
            Object o1 = aclass.newInstance();
            add.invoke(o1,123,123);
            System.out.println("====================");
            ////获取对象的所有构造方法，只能获取公有的改造方法
            Constructor<?>[] constructors = aclass.getConstructors();
            for (Constructor constructor : constructors)
            {
                System.out.println(constructor.getName());
            }
            System.out.println("====================");
            ////获取所有的构造方法，无论是私有还是公有
            Constructor<?>[] declaredConstructors = aclass.getDeclaredConstructors();
            for (Constructor constructor : declaredConstructors)
            {
                System.out.println(constructor.getName());
            }
            System.out.println("====================");
            ////如何调用私有的构造方法呢？
            Constructor<?> declaredConstructor = aclass.getDeclaredConstructor(String.class, int.class, String.class);
            declaredConstructor.setAccessible(true);
            Object o2 = declaredConstructor.newInstance("msb", 23, "java");
            System.out.println(o2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
