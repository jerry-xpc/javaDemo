package com.java.spring.dao;

import com.java.spring.entity.Emp;
import com.sun.scenario.effect.impl.prism.PrImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Emp emp){
        int update = jdbcTemplate.update("insert into EMP(EMPNO,ENAME)values(?,?)",emp.getEmpno(),emp.getEname());
        System.out.println(update);
    }
}
