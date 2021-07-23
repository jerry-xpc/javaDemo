package com.java.jdbc.util;

import java.sql.*;

public class DBUtil {
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:xpc";
    public static final String USERNAME = "scott";
    public static final String PASSWORD = "aaa111";

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getCollection(){
        try {
            return  DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection connection){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection connection,Statement statement){
        try {
            if (statement != null){
                statement.close();
            }

            if (connection != null){
                connection.close();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (resultSet != null){
                resultSet.close();
            }

            if (statement != null){
                statement.close();
            }

            if (connection != null){
                connection.close();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
