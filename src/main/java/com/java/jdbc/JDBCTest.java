package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
    public static void main(String[] args) throws Exception {
        /**
         * 1、加载驱动：
         * 当执行了当前代码之后，会返回一个class对象，在此对象的创建过程中，会调用具体类的静态代码块
         */
        Class.forName("oracle.jdbc.driver.OracleDriver");
        /**
         * 2、建立连接
         * 第一步中已经经driver对象初测到了DriverManager中，所以此时可以直接通过DriverManager来获取数据库的连接
         * 需输入连接数据库的参数：
         * （1）url：数据库的地址
         * （2）username：用户名
         * （3）password：密码
         */
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xpc", "scott", "aaa111");
        //3、测试数据库连接，输出对象表示已经连接
        System.out.println(connection);
        //定义SQL语句,双引号内无需在SQL后面跟分号
        String sql = "select * from emp";
        /**
         * 5、准备静态处理快对象，将SQL语句放置到静态处理块中，理解为sql语句放置对象
         * 在执行sql语句的过程中，需要一个对象来存放sql语句，将对象进行执行的时候调用的是数据的服务，数据库会从当前对象中拿到对应的SQL语句进行执行
         */
        Statement statement = connection.createStatement();
        /**
         * 6、执行sql语句，返回对象是结果集合
         * 将结果放到resultSet中，是返回结果的一个集合，需要经过循环迭代才能获取到其中的每一条数据
         *
         * statement在执行的时候可以选择三种方式：
         * （1）execute：任何SQL语句都可以执行
         * （2）executeQuery：只能执行查询语句
         * （3）executeUpdate：只能执行更新语句
         */
        ResultSet resultSet = statement.executeQuery(sql);
        /**
         * 7、循环处理数据
         * 使用while循环，有两种获取具体值的方式：
         * （1）通过下表索引获取，从1开始
         * （2）通过列名获取
         * 建议通过选择第二种，通过列名获取，因为列名一般不会发生修改
         */
        while (resultSet.next()){
            int anInt = resultSet.getInt(1);
            System.out.println(anInt);
            String ename = resultSet.getString("ename");
            System.out.println(ename);
            System.out.println("-----------------------");
        }
        //8、关闭数据库连接
        statement.close();
        connection.close();
    }
}
