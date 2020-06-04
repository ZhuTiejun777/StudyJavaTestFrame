package com.study.EncapsulationTest;

/**
 * 对象的数据封装特性彻底消除了传统结构方法中数据与操作分离所带来的种种问题，提高了程序的可复用性和可维护性，降低了程序员保持数据与操作内容的负担。
 * 对象的数据封装特性还可以把对象的私有数据和公共数据分离开，保护了私有数据，减少了可能的模块间干扰，达到降低程序复杂性、提高可控性的目的。
 * 封装是把过程和数据包围起来，对数据的访问只能通过已定义的接口。面向对象计算始于这个基本概念，即现实世界可以被描绘成一系列完全自治、封装的对象，
 * 这些对象通过一个受保护的接口访问其他对象。封装是一种信息隐藏技术，在java中通过关键字private，protected和public实现封装。
 * 什么是封装？封装把对象的所有组成部分组合在一起，封装定义程序如何引用对象的数据，封装实际上使用方法将类的数据隐藏起来，
 * 控制用户对类的修改和访问数据的程度。 适当的封装可以让程式码更容易理解和维护，也加强了程式码的安全性。
 */


public class MyClass {
    public static void main(String[] args) {

        Student st = new Student();
        st.setAge(18);
        st.setId(1);
        st.setName("Anthony");

        System.out.println(st.getName() + " number is " + st.getId() + " and "+st.getAge() );

    }
}
