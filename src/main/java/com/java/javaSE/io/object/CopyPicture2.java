package com.java.javaSE.io.object;

import java.io.*;

/**
 * 输入输出图片、视频需要使用到字节流，通过字符流会出现不支持格式
 */
public class CopyPicture2
{
    public static void main(String[] args)  {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("E:\\Java\\IDEAWorkspace\\JavaDemo\\src\\com\\javaSE\\io\\1.jpg");
            outputStream = new FileOutputStream("E:\\Java\\IDEAWorkspace\\JavaDemo\\src\\com\\javaSE\\io\\3.jpg");
            int length = 0;
            byte[] bytes = new byte[1024];
            while ((length = inputStream.read(bytes)) != -1)
            {
                outputStream.write(bytes,0,length);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
