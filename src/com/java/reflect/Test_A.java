package com.java.reflect;

public class Test_A {
    private class inner{}


    public static void main(String[] args) throws Exception{
        System.out.println(Test_A.class.getSimpleName());
        System.out.println(Test_A.class.getName());
        System.out.println(Test_A.class.getCanonicalName());
        System.out.println("=============================");
        System.out.println(inner.class.getSimpleName());
        System.out.println(inner.class.getName());
        System.out.println(inner.class.getCanonicalName());
        System.out.println("==============================");
        System.out.println(args.getClass().getSimpleName());
        System.out.println(args.getClass().getName());
        System.out.println(args.getClass().getCanonicalName());
    }
}
