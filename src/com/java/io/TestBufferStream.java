package com.java.io;

import java.io.*;
import java.nio.Buffer;

public class TestBufferStream
{
    public static void main(String[] args)
    {
        int b = 0;

        try {
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("E:\\other\\test\\test2.txt"));
            out.write("wdwdwdwdwdZ中午");
            System.out.println(out.getEncoding());
            out.close();

            out = new OutputStreamWriter(new FileOutputStream("E:/other/test/test2.txt",true),"UTF-8");
            out.write("3333dadsd哈哈");
            System.out.println(out.getEncoding());
            out.close();

            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader bf = new BufferedReader(isr);
            String s = bf.readLine();
            while (s != null)
            {
                if (s.equalsIgnoreCase("exit"))
                {
                    break;
                }
                System.out.println(s.toUpperCase());
                s = bf.readLine();
            }
            bf.close();

        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }
}
