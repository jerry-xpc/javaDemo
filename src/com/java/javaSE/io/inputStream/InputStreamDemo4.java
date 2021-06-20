package com.javaSE.io.inputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 在java中需要读写文件的数据的话，需要使用流的概念
 * 流表示从搞一个文件将数据返送到另一个文件，包含一个流向的问题，最终需要选择一个参照物：
 * “当前程序作为参照物从一个文件中读取数据到程序叫输入流，从程序输出数据到另一个文件叫输出流”
 *
 * 注意：当编写IO流的程序的时候一定要注意关闭流
 *      步骤：
 *          1、选择合适的io流对象
 *          2、创建对象
 *          3、传输数据
 *          4、关闭流对象（占用系统资源）
 *
 * 存在问题，每次只能读取一个字节，效率比较低，需要循环N多次
 */
public class InputStreamDemo4
{
    public static void main(String[] args)
    {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("E:\\Java\\IDEAWorkspace\\JavaDemo\\src\\com\\javaSE\\file\\abc.txt"));
            int length = 0;
            //添加缓冲区的方式进行读取，每次会将数据添加到缓冲区中，当缓冲区满了之后，一次读取，而不是每一个字节进行读取
            byte[] buff = new byte[1024];
            while ((length = inputStream.read(buff,5,5)) != -1)
            {
                System.out.println(new String(buff,5,5));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 }
