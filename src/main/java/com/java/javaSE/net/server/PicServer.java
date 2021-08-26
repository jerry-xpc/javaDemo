package com.java.javaSE.net.server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PicServer {
    public static void main(String[] args) throws IOException {
        //创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(1800);
        //创建socket套接字对象
        Socket accept = serverSocket.accept();

        //------------------------------接收客户端传输数据-----------------------

        //创建数据读取输入流
        InputStream inputStream = accept.getInputStream();
        //创建文件输出对象
        FileOutputStream fileOutputStream = new FileOutputStream("D://java//idea-workspace//javaDemo//web//WEB-INF//imge//1.jpg");
        int temp = 0;
        while ((temp=inputStream.read()) != -1){
            fileOutputStream.write(temp);
        }
        accept.shutdownInput();

        //---------------------回应客户端----------------------------

        //上传图片结束之后给予客户端响应
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("上传成功".getBytes());
        accept.shutdownOutput();

        //关闭操作
        outputStream.close();
        fileOutputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}
