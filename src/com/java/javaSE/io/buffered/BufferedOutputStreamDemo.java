package com.javaSE.io.buffered;

import java.io.*;

public class BufferedOutputStreamDemo
{
    public static void main(String[] args)
    {
        File file = new File("E:\\Java\\IDEAWorkspace\\JavaDemo\\src\\com\\javaSE\\io\\acb5.txt");
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            try {
                bufferedOutputStream.write(1111);
                bufferedOutputStream.write("wdd点对点".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
