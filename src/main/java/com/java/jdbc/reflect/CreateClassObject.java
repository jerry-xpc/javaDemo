package com.java.jdbc.reflect;

import com.java.jdbc.entity.Emp;

public class CreateClassObject
{
    public static void main(String[] args)
    {
        try {
            //1.通过forName()来获取class对象
            Class<?> aClass = Class.forName("com.java.jdbc.entity.Emp");
            //2.通过类名获取class对象
            Class<Emp> empClass = Emp.class;
            //3.通过对象的getClass()来获取对象
            Class<? extends Emp> aClass1 = new Emp().getClass();
            System.out.println(aClass1.getClass());
            System.out.println(aClass1.getPackage());
            System.out.println(aClass1.getName());
            System.out.println(aClass1.getSimpleName());
            System.out.println(aClass1.getCanonicalName());
            //4.如果是一个基本数据类型，那么可以通过type的方法来回去class对象
            Class<Integer> type = Integer.TYPE;
            System.out.println(type.getName());
            System.out.println(type.getCanonicalName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
