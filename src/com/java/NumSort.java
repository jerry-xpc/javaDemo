package com.java;

public class NumSort
{
    public static void main(String[] args)
    {
        int[] a = new int[args.length];

        for (int i=0;i<args.length;i++)
        {
            a[i] = Integer.parseInt(args[i]);
        }
        print(a);
    }

    public static void print(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            System.out.println(a[i] + " ");
        }
    }
}
