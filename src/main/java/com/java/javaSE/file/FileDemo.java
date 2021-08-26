package com.java.javaSE.file;

import java.io.File;
import java.io.IOException;

/**
 * File提供了对当前文件系统中文件的部分操作
 */
public class FileDemo
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("E:/Java/IDEAWorkspace/javaDemo/src/com/javaSE/file/abc.txt");

        //创建文件
        try {
            file.createNewFile();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //判断文件是否可执行
        System.out.println("判断文件是否可执行："+file.canExecute());
        //判断文件是否可读
        System.out.println("判断文件是否可读："+file.canRead());
        //判断文件是否可写
        System.out.println("判断文件是否可写："+file.canWrite());
        //判断当前文件是否存在
        System.out.println("判断文件是否存在;"+file.exists());
        //获取文件的名称
        System.out.println("获取文件名称："+file.getName());
        //获取文件的绝对路径
        System.out.println("获取文件的绝对路径："+file.getAbsolutePath());
        //获取文件的父路径名称，如果文件的路径中只包含文件的名称，则显示空
        System.out.println("获取文件的父路径"+file.getParent());

        //返回文件绝对路径的规范格式
        System.out.println(file.getCanonicalPath());
        //返回操作系统的文件分隔符
        System.out.println(File.separator);

        File file1 = new File("E:/Java/IDEAWorkspace/javaDemo/src/com/javaSE/file/");
        //无论当前文件是否存在，只要给定具体的路径，都可以返回相应的路径名称
        System.out.println("获取文件file1的绝对路径"+file1.getAbsolutePath());
        //判断目录是否存在
        System.out.println(file1.isDirectory());
        //判断是否文件
        System.out.println(file1.isFile());

        String[] list = file1.list();
        for (String str : list)
        {
            System.out.println(list.toString());
        }

        System.out.println("======================");

        //获取当前目录下所有文件
        File[] files = file1.listFiles();
        for (File f: files)
        {
            System.out.println(f);
        }

        //获取系统根目录
        File[] files2 = File.listRoots();
        for (int i=0;i<files2.length;i++)
        {
            System.out.println(files2[i]);
        }

        //创建单级目录
        File file3 = new File("E:/test");
        file3.mkdir();

        //创建多级目录
        File file4 = new File("E:/test/a/b");
        file4.mkdirs();

        //循环变量输出E盘中的所有文件的绝对路径
        //使用递归的方式
        printFile(new File("E:/Java"));
    }

    /**
     * 文件在遍历的时候，会出现空指针的问题，原因在于当前文件系统安全保护，某些文件没有访问权限，此时会报空指针异常
     * @param file
     */
    public static void printFile(File file)
    {
        if (file.isDirectory())
        {
            File[] files = file.listFiles();
            for (File f : files)
            {
                printFile(f);
            }
        }
        else
        {
            System.out.println("此文件是一个具体的文件，只有一个文件名称");
            System.out.println(file.getAbsolutePath());
        }
    }
}
