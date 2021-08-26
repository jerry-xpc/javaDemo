package com.java.javaSE.io.inputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderDemo
{
    public static void main(String[] args) {
        InputStreamReader inputStreamReader = null;
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream("E:\\Java\\IDEAWorkspace\\JavaDemo\\src\\com\\javaSE\\io\\abc1.txt");
            inputStreamReader = new InputStreamReader(fileInputStream,"ISO8859-1");
            char[] chars = new char[1024];
            int length = 0;
            while ((length = inputStreamReader.read(chars)) != -1)
            {
                System.out.println(new String(chars,0,length));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try {
                inputStreamReader.close();
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
