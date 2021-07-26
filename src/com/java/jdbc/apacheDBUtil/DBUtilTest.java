package com.java.jdbc.apacheDBUtil;

import com.java.jdbc.util.MySQLDBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtilTest {

    public static Connection connection;


    public static void insert() throws Exception{
        String sql = "insert into emp(empno,ename)values(?,?)";
        connection = MySQLDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        for (int i=0;i<10;i++)
        {
            queryRunner.update(connection,sql,i,"mashibing"+i);
        }

        connection.close();
    }

    public static void testQuery() throws SQLException
    {
        connection = MySQLDBUtil.getConnection();
        String sql = "select * from emp where empno=?";

    }

    public static void main(String[] args) {
        try {
            insert();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
