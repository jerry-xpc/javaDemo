package com.java.spring.service.impl;

import com.java.spring.service.Calculator;
import org.springframework.stereotype.Service;

@Service
public class MyCalculatorImpl implements Calculator {
    @Override
    public Integer add(Integer i, Integer j) throws NoSuchMethodException {
        return i+j;
    }

    @Override
    public Integer sub(Integer i, Integer j) throws NoSuchMethodException {
        return i-j;
    }

    @Override
    public Integer mul(Integer i, Integer j) throws NoSuchMethodException {
        return i*j;
    }

    @Override
    public Integer div(Integer i, Integer j) throws NoSuchMethodException {
        return i/j;
    }
}
