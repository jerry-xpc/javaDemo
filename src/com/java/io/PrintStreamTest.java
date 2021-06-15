package com.java.io;

import java.io.*;
import java.util.Date;

public class PrintStreamTest
{
    public static void main1(String[] args)
    {
        PrintStream ps = null;

        try
        {
            FileOutputStream fos = new FileOutputStream("E:\\other\\test\\test2.txt");
            ps = new PrintStream(fos);


        }catch (Exception e)
        {
            e.getMessage();
        }


        if(ps != null)
        {
            System.setOut(ps);
        }

        int i = 0;
        for (char c = 0;c <= 60000;c++)
        {
            System.out.println(c+"");
            if(i++ >= 100)
            {
                System.out.println();
                i=0;
            }
        }
    }

    public static void main2(String[] args)
    {
        String fileName = "D:\\java\\idea-workspace\\javaDemo\\src\\com\\java\\io\\DataInputStreamTest.java";
        if (fileName != null)
        {
            list(fileName,System.out);
        }
    }

    public static void list(String f,PrintStream fs)
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            BufferedWriter bw = new BufferedWriter(new FileWriter("E:/other/test/test4.txt"));
            String s = null;
            while ((s = br.readLine()) != null)
            {
                fs.println(s);
                bw.write(s);
            }
            br.close();
            bw.close();
        }
        catch (Exception e)
        {
            fs.println("无法读取文件");
        }
    }

    public static void main(String[] args)
    {
        String s = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            FileWriter fw = new FileWriter("E:/other/test/test5.txt",true);

            PrintWriter pw = new PrintWriter(fw);

            while ((s = br.readLine()) != null)
            {
                if (s.equalsIgnoreCase("exit"))
                {
                    break;
                }

                System.out.println(s.toUpperCase());
                pw.println("--------");
                pw.println(s.toUpperCase());
                pw.flush();
            }
            pw.println("-----"+new Date()+"-----");
            pw.flush();
            pw.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main3(String[] args) {
        
    }
}
