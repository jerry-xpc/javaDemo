package com.javaSE.io.OutputStream;

import java.io.*;

public class OutputStreamWriteDemo
{
    public static void main(String[] args)
    {
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        try
        {
            fileOutputStream = new FileOutputStream("E:\\Java\\IDEAWorkspace\\JavaDemo\\src\\com\\javaSE\\io\\abc1.txt");
            outputStreamWriter = new OutputStreamWriter(fileOutputStream,"utf-8");
            outputStreamWriter.write("马士兵很牛逼");
            outputStreamWriter.write("addddfffwfqf",0,5);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            //关闭流对象的时候，建议按照创建的顺序的逆序进行关闭
            try {
                outputStreamWriter.close();
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
