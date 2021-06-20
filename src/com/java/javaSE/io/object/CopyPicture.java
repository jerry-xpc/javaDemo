package com.javaSE.io.object;

import java.awt.event.WindowEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 输入输出图片、视频需要使用到字节流，通过字符流会出现不支持格式
 */
public class CopyPicture
{
    public static void main(String[] args)  {
        FileReader reader = null;
        FileWriter writer = null;

        try {
            reader = new FileReader("E:\\Java\\IDEAWorkspace\\JavaDemo\\src\\com\\javaSE\\io\\1.jpg");
            writer = new FileWriter("E:\\Java\\IDEAWorkspace\\JavaDemo\\src\\com\\javaSE\\io\\2.jpg");
            int length = 0;
            char[] chars = new char[1024];
            while ((length = reader.read(chars)) != -1)
            {
                writer.write(chars,0,length);
            }
            writer.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try {
                writer.close();
                reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
