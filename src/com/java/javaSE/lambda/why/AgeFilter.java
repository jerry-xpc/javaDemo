package com.java.javaSE.lambda.why;

public class AgeFilter implements StudentFilter{
    @Override
    public boolean compare(Student student) {
        return student.getAge() > 13;
    }
}
