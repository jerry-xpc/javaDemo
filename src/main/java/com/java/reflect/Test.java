package com.java.reflect;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws Exception{
        Class<Dog>  dogClass = Dog.class;

        System.out.println(dogClass.getName());
        System.out.println(dogClass.getSimpleName());
        System.out.println(dogClass.getCanonicalName());
        System.out.println(dogClass.isInterface());
        for (Class c : dogClass.getInterfaces()){
            System.out.println(c);
        }

        System.out.println("=============================");


        System.out.println(dogClass.getSuperclass());
        Dog dog = dogClass.newInstance();
        for (Field f : dogClass.getFields()){
            System.out.println(f.getName());
        }

        System.out.println("=============================");

        for (Field f : dogClass.getDeclaredFields()){
            System.out.println(f.getName());
        }
    }
}


interface I1{}

interface I2{}

class Cell{
    public int mCellPublic;
}

class Animal extends Cell{
    private int mAnimalPrivet;
    protected int mAnimalProtected;
    int mAnimalDefault;
    public int mAnimalPublic;
    private static int sAnimalPrivate;
    protected static int sAnimalProtected;
    static int sAnimalDefault;
    public static int sAnimalPublic;
}

class Dog extends Animal implements I1,I2{
    private int mDogPrivate;
    public int mDogPublic;
    protected int mDogProtected;
    private int mDogDefault;
    private static int sDogPrivate;
    protected static int sDogProtected;
    static int sDogDefault;
    public static int sDogPublic;
}