package com.java.spring.service.impl;

import com.java.spring.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {
    @Autowired
    public BaseDao<T> baseDao;

    public void save(){
        baseDao.save();
    }
}
