package com.java.javaSE.net.client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        //创建UDP套接字对象
        DatagramSocket datagramSocket = new DatagramSocket(1000);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你想输入的信息：");
        String str = scanner.nextLine();
        //传输数据
        DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(),str.getBytes().length, InetAddress.getByName("localhost"),1001);
        //将写入的数据发送到服务端
        datagramSocket.send(datagramPacket);
        //关闭套接字对象流
        datagramSocket.close();
    }
}
