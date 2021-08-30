package com.java.spring.dao;

import com.java.spring.bean.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDao extends BaseDao<Teacher>{
    @Override
    public void save() {
        System.out.println("保存老师成功！");
    }
}
