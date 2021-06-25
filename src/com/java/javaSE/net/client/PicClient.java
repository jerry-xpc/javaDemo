package com.java.javaSE.net.client;

import java.io.*;
import java.net.Socket;

public class PicClient {
    public static void main(String[] args) throws IOException {
        //创建套接字对象socket
        Socket socket = new Socket("127.0.0.1", 1800);

        //-------------------客户端访问服务端传输---------------------------

        //创建文件输入流，获取到本地的图片
        FileInputStream fileInputStream = new FileInputStream("D://java//idea-workspace//imge//1.jpg");
        //获取传输输出对象
        OutputStream outputStream = socket.getOutputStream();
        int temp = 0;
        //循环从文件输入流中读取，将数据写入输出流传输到服务端
        while ((temp=fileInputStream.read()) != -1){
            outputStream.write(temp);
        }
        //因为是文件传输比较大，需要手动关闭传输流，不然服务器一直运行
        socket.shutdownOutput();

        //-------------------客户端接收服务端传输----------------------------

        //接收服务端响应
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        System.out.println("接收服务端响应消息："+new String(bytes,0,read));
        socket.shutdownInput();

        //关闭全部流
        inputStream.close();
        outputStream.close();
        fileInputStream.close();
        socket.close();
    }
}
