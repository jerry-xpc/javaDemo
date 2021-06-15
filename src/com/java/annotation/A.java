package com.java.annotation;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A {
    public void test(){

    }

    public static void main(String[] args) {
        B b = new B();
        b.oldMethod();
    }
}

class B extends A{

    @Override
    public void test() {
    }

    @Deprecated
    public void oldMethod(){

    }

    @SuppressWarnings("rawtypes")
    public List processList(){
        List list = new ArrayList();
        return list;
    }
}