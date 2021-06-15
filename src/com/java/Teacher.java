package com.java;

public class Teacher implements  Singer,Painter
{
    private String name;

    public String getString()
    {
        return  name;
    }

    public Teacher(){}

    public Teacher(String name)
    {
        this.name = name;
    }

    @Override
    public void paint()
    {
        System.out.println("teacher is painting");
    }

    @Override
    public void eat()
    {
        System.out.println("teacher is eating");
    }

    @Override
    public void sing()
    {
        System.out.println("teacher is singing");
    }

    @Override
    public void sleep()
    {
        System.out.println("teacher is sleeping");
    }

    public void pint()
    {
        System.out.println("测试");
    }
}
