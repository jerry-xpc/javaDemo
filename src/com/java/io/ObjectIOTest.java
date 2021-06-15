package com.java.io;

import java.io.*;

public class ObjectIOTest
{
    public static void main(String[] args)
    {
        try {
            T t = new T();
            t.k = 8;
            FileOutputStream fos = new FileOutputStream("E:/other/test/test6.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(t);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("E:/other/test/test6.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            T t1 = (T) ois.readObject();
            System.out.println(t1.i + " "+t1.j+" "+t1.d+" "+t1.k);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

class  T implements Serializable
{
    int i = 10;
    int j = 9;
    double d = 2.3;
    transient int k = 15;

}