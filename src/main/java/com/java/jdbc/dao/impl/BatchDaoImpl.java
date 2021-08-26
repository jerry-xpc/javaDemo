package com.java.jdbc.dao.impl;

import com.java.jdbc.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchDaoImpl {
    public static void insertBatch(){
        Connection collection = DBUtil.getCollection();
        PreparedStatement statement = null;
        String sql = "insert into emp(empno,ename) values (?,?)";

        try {
            statement = collection.prepareStatement(sql);
            for (int i=0;i<10;i++){
                statement.setInt(1,i);
                statement.setString(2,"msb"+i);
                statement.addBatch();
            }
            int[] ints = statement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(collection,statement);
        }
    }

    public static void main(String[] args) {
        insertBatch();
    }
}
