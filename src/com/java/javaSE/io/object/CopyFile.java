package com.javaSE.io.object;

import java.io.*;

public class CopyFile
{
    public static void main(String[] args) {
        //定义源数据文件
        File file1 = new File("E:\\Java\\IDEAWorkspace\\JavaDemo\\src\\com\\javaSE\\io\\abc.txt");
        //定义目的数据文件
        File file2 = new File("E:\\Java\\IDEAWorkspace\\JavaDemo\\src\\com\\javaSE\\io\\acb2.txt");
        //创建输入流对象
        InputStream inputStream = null;
        //创建输出流对象
        OutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(file1);
            outputStream = new FileOutputStream(file2);

            //带缓存的输入输出方式
            byte[] buffer = new byte[1024];
            int length = 0;

            //完成数据传输过程
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer,0,length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
