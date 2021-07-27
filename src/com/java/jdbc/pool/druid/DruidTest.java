package com.java.jdbc.pool.druid;

import com.alibaba.druid.pool.*;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidTest
{
    public static void main(String[] args)throws Exception {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/druid.properties");
        properties.load(fileInputStream);

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
