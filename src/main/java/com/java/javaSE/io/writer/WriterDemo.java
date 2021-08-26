package com.java.javaSE.io.writer;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 什么时候需要加flush，什么时候不需要加flush
 *      最保险的方式，在输出流关闭之前每次都flush，然后关闭流
 *      当某一个输出流对象中带有缓存区的时候，就需要进行flush，不建议大家去记住每个输出流的分类
 */
public class WriterDemo
{
    public static void main(String[] args)
    {
        Writer writer = null;

        try
        {
            writer = new FileWriter("E:\\Java\\IDEAWorkspace\\JavaDemo\\src\\com\\javaSE\\io\\acb4.txt");
            writer.write("hello 您好");
            writer.write("哈哈哈 中国万岁");
            writer.flush();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
