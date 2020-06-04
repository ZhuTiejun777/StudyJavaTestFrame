package com.study.AbstractTest;

public class StudyAbstractExercise {
    public static void main(String[] args) {
        StudyAbstract student = new StudyAbstractTest();
        System.out.println(student.getAge());
        //StudyAbstract是抽象类，无法被实例化
        //StudyAbstract students = new StudyAbstract();
    }
}
