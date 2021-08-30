package com.java.spring.proxy;

import com.java.spring.service.Calculator;
import com.java.spring.util.LogUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CalculatorProxy {
    public static Calculator getProxy(final  Calculator calculator){
        //获取被代理对象的类加载器
        ClassLoader loader = calculator.getClass().getClassLoader();
        //被代理对象的所有接口
        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        //用来执行被代理类需要执行的方法
        InvocationHandler invoke = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
//                    LogUtil.start();
                    result = method.invoke(calculator, args);
//                    LogUtil.stop();
                }catch (Exception e){
//                    LogUtil.logException();
                }finally {
//                    LogUtil.logFinally();
                }
                return result;
            }
        };

        Object o = Proxy.newProxyInstance(loader, interfaces, invoke);
        return (Calculator) o;
    }
}
