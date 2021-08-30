package com.java.spring.service.impl;

import com.java.spring.dao.PersonDao;
import com.java.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonSerciceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;
    @Override
    public void save() {
        personDao.save();
    }
}
