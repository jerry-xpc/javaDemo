package com.java.spring.service.impl;

import com.java.spring.dao.BookDao;
import com.java.spring.dao.EmpDao;
import com.java.spring.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
    @Autowired
    BookDao bookDao;
    @Autowired
    EmpDao empDao;
    @Transactional(propagation = Propagation.NESTED)
    public void buyBook(){
        bookDao.getPrice(1);
        bookDao.updateBalance("zhangsan", 100);
        int i = 1/0;
        bookDao.updateStock(1);
    }

    @Transactional(propagation = Propagation.NESTED)
    public void updatePrice() {
        bookDao.updatePrice(1);
    }

    @Transactional
    public void updateEmp(Emp emp){
        empDao.update(emp);
        empDao.save(emp);

    }
}
