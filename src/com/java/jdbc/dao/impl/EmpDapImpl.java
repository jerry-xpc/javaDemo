package com.java.jdbc.dao.impl;

import com.java.jdbc.dao.EmpDao;
import com.java.jdbc.entity.Emp;
import com.java.jdbc.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

public class EmpDapImpl implements EmpDao {
    Connection connection = null;
    Statement statement = null;

    @Override
    public void insert(Emp emp) {
        try {
            connection = DBUtil.getCollection();
            //设置事务是否自动提交，true表示自动提交 false表示不自动提交
            connection.setAutoCommit(true);
            statement = connection.createStatement();
            String sql = "insert into emp values(" + emp.getEmpno() + ",'" + emp.getEname() + "','" + emp.getJob() + "',"
                    + emp.getMrg() + ",to_date('" + emp.getHiredate() + "','YYYY-MM-DD')," + emp.getSal() + ","
                    + emp.getComm() + "," + emp.getDeptno() + ")";
            System.out.println(sql);
            //返回值表示受影响的行数
            int i= statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection,statement);
        }
    }

    @Override
    public void delete(Emp emp) {
        try {
            connection = DBUtil.getCollection();
            statement = connection.createStatement();
            String sql = "delete from emp where empno = " + emp.getEmpno();
            System.out.println(sql);
            int i = statement.executeUpdate(sql);
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection,statement);
        }
    }

    @Override
    public void update(Emp emp) {
        try {
            connection = DBUtil.getCollection();
            statement = connection.createStatement();
            String sql = "update emp set job = '" + emp.getJob() + "' where empno = " + emp.getEmpno();
            System.out.println(sql);
            int i = statement.executeUpdate(sql);
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection,statement);
        }
    }

    @Override
    public Emp getEmpByEmpno(Integer empno) {
        ResultSet resultSet = null;
        Emp emp = null;
        try {
            connection = DBUtil.getCollection();
            statement = connection.createStatement();
            String sql = "select * from emp where empno = " + empno;
            System.out.println(sql);
            resultSet = statement.executeQuery(sql);
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
            while (resultSet.next()){
                emp = new Emp(resultSet.getInt("empno"), resultSet.getString("ename"), resultSet.getString("job"),
                        resultSet.getInt("mgr"), sdf.format(resultSet.getDate("hiredate")), resultSet.getDouble("sal"),
                        resultSet.getDouble("comm"), resultSet.getInt("deptno"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection,statement,resultSet);
        }
        return emp;
    }

    @Override
    public Emp getEmpByEname(String name) {
        ResultSet resultSet = null;
        Emp emp = null;
        try {
            connection = DBUtil.getCollection();
            statement = connection.createStatement();
            String sql = "select * from emp where ename = " + name;
            System.out.println(sql);
            resultSet = statement.executeQuery(sql);
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
            while (resultSet.next()){
                emp = new Emp(resultSet.getInt("empno"), resultSet.getString("ename"), resultSet.getString("job"),
                        resultSet.getInt("mgr"), sdf.format(resultSet.getDate("hiredate")), resultSet.getDouble("sal"),
                        resultSet.getDouble("comm"), resultSet.getInt("deptno"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection,statement,resultSet);
        }
        return emp;
    }

    public static void main(String[] args) {
        EmpDao empDao = new EmpDapImpl();
        Emp emp = new Emp(3333, "sisi", "SALES", 1111, "2019-11-09", 1500.0, 500.0, 10);
        //empDao.insert(emp);
        //empDao.delete(emp);
        //empDao.update(emp);
        //System.out.println(empDao.getEmpByEmpno(7369));
        System.out.println(empDao.getEmpByEname("'SMITH'"));
    }
}
