package com.java.jdbc.pool.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C3P0Test
{
    public static Connection connection;
    public static ComboPooledDataSource dataSource;

    public static void getConnection()
    {
        dataSource = new ComboPooledDataSource();
    }

    public static void queryData()
    {
        try {
            connection = dataSource.getConnection();
            String sql = "select * from emp";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                System.out.println(resultSet.getString("ename"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/tran");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("aaa111");
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);
        connection.close();

        System.out.println("==================");
        getConnection();
        queryData();
    }
}
