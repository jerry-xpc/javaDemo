package com.java.spring.dao;

import com.java.spring.bean.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao extends BaseDao<Student>{
    @Override
    public void save() {
        System.out.println("保存学生成功！");
    }
}
