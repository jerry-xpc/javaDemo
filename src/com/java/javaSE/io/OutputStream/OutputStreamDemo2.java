package com.javaSE.io.OutputStream;

import java.io.*;

public class OutputStreamDemo2
{
    public static void main(String[] args)
    {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try
        {
            byte[] bytes = new byte[1024];
            inputStream = new FileInputStream(new File("E:\\Java\\IDEAWorkspace\\JavaDemo\\src\\com\\javaSE\\io\\abc.txt"));
            int length = 0;
            String str = null;
            byte[] b = null;
            while ((length = inputStream.read(bytes)) != -1)
            {
                b = new String(bytes,0,length).getBytes();
            }

            outputStream = new FileOutputStream(new File("E:\\Java\\IDEAWorkspace\\JavaDemo\\src\\com\\javaSE\\io\\acb1.txt"));
            outputStream.write(b);
            outputStream.write("abc1123".getBytes());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                outputStream.close();
                inputStream.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
