package com.java.annotation;

import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestMethodAnnotation {
    @Override
    @MyMethodAnnotation(title = "toStringMethod",description = "override toString  method")
    public String toString(){
        return "Override toString method";
    }

    @Deprecated
    @MyMethodAnnotation(title = "old static method",description = "deprecated old static method")
    public static void oldMethod(){
        System.out.println("old method,don't use it.");
    }

    @SuppressWarnings({"unchecked","deprecation"})
    @MyMethodAnnotation(title = "test method",description = "suppress warning static method")
    public static void genericsTest()throws FileNotFoundException {
        List list = new ArrayList();
        list.add("abc");
        oldMethod();
    }

    public static void main(String[] args) {
        try {
            Method[] methods = TestMethodAnnotation.class.getClassLoader().loadClass("com.java.annotation.TestMethodAnnotation").getMethods();
            for (Method method : methods){
                if (method.isAnnotationPresent(MyMethodAnnotation.class)){
                    try {
                        for (Annotation annotation : method.getDeclaredAnnotations()){
                            System.out.println("Annotation in method:"+method+": "+annotation);
                        }

                        MyMethodAnnotation myMethodAnnotation = method.getAnnotation(MyMethodAnnotation.class);
                        System.out.println(myMethodAnnotation.title());
                    }catch (Throwable ex){
                        ex.printStackTrace();
                    }
                }
            }
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }
}
