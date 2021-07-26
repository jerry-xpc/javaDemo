package com.java.jdbc.dao.impl;

import com.java.jdbc.dao.EmpDao;
import com.java.jdbc.entity.Emp;
import com.java.jdbc.util.DBUtil;

import java.sql.*;
import java.text.SimpleDateFormat;

public class EmpDaoImpl2 implements EmpDao {
    @Override
    public void insert(Emp emp) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
            connection = DBUtil.getCollection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,emp.getEmpno());
            statement.setString(2,emp.getEname());
            statement.setString(3,emp.getJob());
            statement.setInt(4,emp.getMrg());
            statement.setDate(5,new java.sql.Date(new SimpleDateFormat("yyyy-MM-DD").parse(emp.getHiredate()).getTime()));
            statement.setDouble(6,emp.getSal());
            statement.setDouble(7,emp.getComm());
            statement.setInt(8,emp.getDeptno());
            int i = statement.executeUpdate();
            System.out.println(i);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection,statement);
        }
    }

    @Override
    public void delete(Emp emp) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            String sql = "delete from emp where empno = ?" ;
            connection = DBUtil.getCollection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,emp.getEmpno());
            int i = statement.executeUpdate();
            System.out.println(i);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection,statement);
        }
    }

    @Override
    public void update(Emp emp) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBUtil.getCollection();
            String sql = "update emp set job = '" + emp.getJob() + "' where empno = " + emp.getEmpno();
            statement = connection.prepareStatement(sql);
            System.out.println(sql);
            //返回值表示受影响的行数
            int i = statement.executeUpdate(sql);
            System.out.println("受影响的行数是：" + i);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection, statement);
        }
    }

    @Override
    public Emp getEmpByEmpno(Integer empno) {
        Connection connection = null;
        Statement statement = null;
        Emp emp = new Emp();
        try {
            connection = DBUtil.getCollection();
            String sql = "select * from emp where empno = " + empno;
            statement = connection.prepareStatement(sql);
            System.out.println(sql);
            //返回值表示受影响的行数
            ResultSet resultSet = statement.executeQuery(sql);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            while (resultSet.next()){
                emp = new Emp(resultSet.getInt("empno"), resultSet.getString("ename"), resultSet.getString("job"),
                        resultSet.getInt("mgr"), sdf.format(resultSet.getDate("hiredate")), resultSet.getDouble("sal"),
                        resultSet.getDouble("comm"), resultSet.getInt("deptno"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection, statement);
        }
        return emp;
    }

    @Override
    public Emp getEmpByEname(String name) {
        Connection connection = null;
        Statement statement = null;
        Emp emp = new Emp();
        try {
            connection = DBUtil.getCollection();
            String sql = "select * from emp where ename = '" + name+"'";
            statement = connection.prepareStatement(sql);
            System.out.println(sql);
            //返回值表示受影响的行数
            ResultSet resultSet = statement.executeQuery(sql);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            while (resultSet.next()){
                emp = new Emp(resultSet.getInt("empno"), resultSet.getString("ename"), resultSet.getString("job"),
                        resultSet.getInt("mgr"), sdf.format(resultSet.getDate("hiredate")), resultSet.getDouble("sal"),
                        resultSet.getDouble("comm"), resultSet.getInt("deptno"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection, statement);
        }
        return emp;
    }

    public static void main(String[] args) {
        EmpDao empDao = new EmpDaoImpl2();
        Emp emp = new Emp(3333, "sisi", "SALES", 1111, "2019-11-09", 1500.0, 500.0, 10);
//        empDao.insert(emp);
//        empDao.delete(emp);
//        empDao.update(emp);
//        System.out.println(empDao.getEmpByEmpno(emp.getEmpno()));
        System.out.println(empDao.getEmpByEname(emp.getEname()));
    }
}
