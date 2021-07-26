package com.java.jdbc.util;

import java.sql.*;

public class MySQLDBUtil {
    public static final String URL = "jdbc:mysql://localhost:3306/tran";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "aaa111";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection connection){
        try{
            if (connection != null){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void closeConnection(Connection connection, Statement statement){
        try{
            if (statement != null){
                statement.close();
            }

            if (connection != null){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet){
        try{
            if (resultSet != null){
                resultSet.close();
            }

            if (statement != null){
                statement.close();
            }

            if (connection != null){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
