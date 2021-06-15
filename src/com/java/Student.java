package com.java;

public class Student implements Singer
{
    private  String name;

    public  Student(String name)
    {
        this.name = name;
    }

    @Override
    public void sing()
    {
        System.out.println("student is singing");
    }

    @Override
    public void sleep()
    {
        System.out.println("student is sleeping");
    }

    public String getName()
    {
        return name;
    }
}
