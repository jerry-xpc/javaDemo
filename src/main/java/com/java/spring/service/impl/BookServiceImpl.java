package com.java.spring.service.impl;

import com.java.spring.dao.BookDao;
import com.java.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    @Transactional
    @Override
    public void buyBook() throws FileNotFoundException {
        bookDao.getPrice(1);
        bookDao.updateBalance("zhangsan", 100);
        bookDao.updateStock(1);
//        int i = 1/0;
    }
}
