package com.java.jdbc.reflect;

import com.java.jdbc.entity.Dept;
import com.java.jdbc.entity.Emp;
import com.java.jdbc.util.DBUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class BaseDaoImpl
{
    public List getRows(String sql,Object[] params,Class clazz)
    {
        List list = new ArrayList();
        Connection collection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            //建立数据库连接
            collection = DBUtil.getCollection();
            //创建prepareStatement对象
            statement = collection.prepareStatement(sql);
            if (statement != null)
            {
                for (int i=0;i<params.length;i++)
                {
                    //sql语句填充参数
                    statement.setObject(i+1,params[i]);
                }
            }
            //开始执行查询操作，resultSet中有返回的结果，需要将返回结果放置到不同的对象中
            resultSet = statement.executeQuery();
            //获取结果集合的元数据对象
            ResultSetMetaData metaData = resultSet.getMetaData();
            //判断查询到的每一行记录中包含多少个列
            int columnCount = metaData.getColumnCount();
            //循环遍历resultSet集合
            while (resultSet.next())
            {
                Object o = clazz.newInstance();
                for (int i=0;i<columnCount;i++)
                {
                    //从结果集中获取单一列的值
                    Object object = resultSet.getObject(i + 1);
                    //获取列的名称
                    String name = metaData.getColumnName(i + 1).toLowerCase();
                    //获取类中的属性
                    Field declaredField = clazz.getDeclaredField(name);
                    //获取类中属性对应的set方法
                    Method method = clazz.getMethod(getSetName(name), declaredField.getType());

                    if (object instanceof Number)
                    {Number number = (Number) object;
                        String fname = declaredField.getType().getName();
                        if("int".equals(fname)||"java.lang.Integer".equals(fname)){
                            method.invoke(o,number.intValue());
                        }else if("byte".equals(fname)||"java.lang.Byte".equals(fname)){
                            method.invoke(o,number.byteValue());
                        }else if("short".equals(fname)||"java.lang.Short".equals(fname)){
                            method.invoke(o,number.shortValue());
                        }else if("long".equals(fname)||"java.lang.Long".equals(fname)){
                            method.invoke(o,number.longValue());
                        }else if("float".equals(fname)||"java.lang.Float".equals(fname)){
                            method.invoke(o,number.floatValue());
                        }else if("double".equals(fname)||"java.lang.Double".equals(fname)){
                            method.invoke(o,number.doubleValue());
                        }
                    }else{
                        method.invoke(o,object);
                    }
                }
                list.add(o);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(collection,statement,resultSet);
        }
        return list;
    }

    public String getSetName(String name){
        return "set"+name.substring(0,1).toUpperCase()+name.substring(1);
    }

    public static void main(String[] args) {
        BaseDaoImpl dao = new BaseDaoImpl();
        List rows = dao.getRows("select empno,ename,sal,deptno from emp where deptno =?", new Object[]{10}, Emp.class);
        for(Iterator it = rows.iterator();it.hasNext();)
        {
            Emp emp = (Emp) it.next();
            System.out.println(emp);
        }

        System.out.println("===========================");

        List row = dao.getRows("select deptno,dname,loc from dept", new Object[]{}, Dept.class);
        for(Iterator it = row.iterator();it.hasNext();)
        {
            Dept emp = (Dept) it.next();
            System.out.println(emp);
        }
    }
}
