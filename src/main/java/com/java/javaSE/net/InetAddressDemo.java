package com.java.javaSE.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            //给出原始IP地址的 InetAddress对象
            InetAddress[] allByName = InetAddress.getAllByName("DESKTOP-USR9E66");
            System.out.println(allByName);
            //返回本地主机的地址
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
            //确定主机名称的IP地址
            InetAddress byName = InetAddress.getByName("DESKTOP-USR9E66");
            System.out.println(byName);
            InetAddress byName1 = InetAddress.getByName("www.baidu.com");
            System.out.println(byName1);
            //获取ip地址
            System.out.println(byName1.getHostAddress());
            //获取主机名称（域名）
            System.out.println(byName1.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
