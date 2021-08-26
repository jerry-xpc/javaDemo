package com.java;

public class Test
{
    public static void main(String[] args)
    {
        Singer s1 = new Student("le");
        s1.sing();
        s1.sleep();

        Singer s2 = new Teacher("steven");
        s2.sing();
        s2.sleep();

        Painter p1 = (Painter) s2;
        p1.paint();
        p1.eat();

        Teacher t1 = new Teacher();
        t1.pint();
    }
}
