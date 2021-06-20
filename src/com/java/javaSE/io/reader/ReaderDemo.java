package com.java.javaSE.io.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 字符流可以直接读取中文汉子，而字节流在处理的时候出现中文会出现乱码
 */
public class ReaderDemo
{
    public static void main(String[] args)
    {
        Reader reader = null;

        try {
            reader = new FileReader("E:\\Java\\IDEAWorkspace\\JavaDemo\\src\\com\\javaSE\\io\\abc.txt");
            int read = 0;
            while ((read = reader.read()) != -1)
            {
                System.out.print((char)read);
            }
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
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
