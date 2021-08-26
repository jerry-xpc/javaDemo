package com.java.jdbc.pool.HikariCP;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public class HikariCPTest
{
    public static void main(String[] args) throws  Exception{
        HikariConfig config = new HikariConfig("src/hikariCP.properties");
        HikariDataSource dataSource = new HikariDataSource(config);


        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
