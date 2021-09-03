package com.java.spring.service.impl;

import org.springframework.stereotype.Service;
@Service
public class MyCalculatorImpl1 {
    public Integer add(Integer i, Integer j) throws NoSuchMethodException {
        return i+j;
    }

    public Integer sub(Integer i, Integer j) throws NoSuchMethodException {
        return i-j;
    }

    public Integer mul(Integer i, Integer j) throws NoSuchMethodException {
        return i*j;
    }

    public Integer div(Integer i, Integer j) throws NoSuchMethodException {
        return i/j;
    }
}
