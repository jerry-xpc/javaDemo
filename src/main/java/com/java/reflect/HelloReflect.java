package com.java.reflect;

import java.lang.reflect.Method;

public class HelloReflect {

    public static void main(String[] args) throws Exception{
        TempFunctionTest t = (TempFunctionTest) Class.forName("com.java.reflect.TempFunctionTest").newInstance();
        t.sayHello("call directly");

        Object t2 = new TempFunctionTest();
        Method m = t2.getClass().getDeclaredMethod("sayHello", String.class);
        m.invoke(t,"method invoke");
    }
}

class TempFunctionTest {
    public void sayHello(String woed){
        System.out.println("hello:"+woed);
    }
}