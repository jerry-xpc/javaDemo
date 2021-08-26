package com.java.jdbc.dao;

import com.java.jdbc.entity.Emp;

public interface EmpDao {
    public void insert(Emp emp);

    public void delete(Emp emp);

    public void update(Emp emp);

    public Emp getEmpByEmpno(Integer empno);

    public Emp getEmpByEname(String name);
}
