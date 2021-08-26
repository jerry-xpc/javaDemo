package com.java.reflect;

import java.lang.reflect.Method;

public class ReflectMethod {
    public static void main(String[] args) throws Exception{
        Class<?> c = Class.forName("com.java.reflect.Circle");

        Method method = c.getMethod("draw",int.class,String.class);
        System.out.println("method:"+method);

        Method[] methods = c.getMethods();
        for (Method m : methods){
            System.out.println("m:"+m);
        }

        System.out.println("==================================");
        Method method1 = c.getDeclaredMethod("drawCircle");
        System.out.println("method1:"+method1);

        Method[] methods2 = c.getDeclaredMethods();
        for (Method m : methods2){
            System.out.println("m2:"+m);
        }


        System.out.println("===================================");
        //锚定指定的类
        Class<?> cl = Class.forName("com.java.reflect.Circle");
        //创建实例，反射写法
        Circle circle = (Circle) cl.newInstance();
        //获取指定参数的方法对象method
        Method m = cl.getMethod("draw",int.class,String.class);
        //通过Method对戏的invoke方法调用
        m.invoke(circle,15,"哈哈");
        //对私有无参方法的操作
        Method m1 = cl.getDeclaredMethod("drawCircle");
        //修改方法的标识
        m1.setAccessible(true);
        m1.invoke(circle);
        //对返回值得方法操作
        Method m2 = cl.getDeclaredMethod("getAllCount");
        Integer count = (Integer) m2.invoke(circle);
        System.out.println("count:"+count);
    }
}

class Shape{
    public void draw(){
        System.out.println("drwa");
    }

    public void draw(int count,String name){
        System.out.println("drwa:"+name+",count"+count);
    }
}

class Circle extends Shape{
    private void drawCircle(){
        System.out.println("drawCircle");
    }

    public int getAllCount(){
        return 100;
    }
}