package com.java.javaSE.io.buffered;

import java.io.*;

public class BufferedInputStreamDemo
{
    public static void main(String[] args) {
        File file = new File("E:\\Java\\IDEAWorkspace\\JavaDemo\\src\\com\\javaSE\\io\\acb4.txt");
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;

        try
        {
            fileInputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            int read = 0;
            while ((read = bufferedInputStream.read()) != -1)
            {
                bufferedInputStream.skip(4);
                System.out.print((char) read);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally {
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
