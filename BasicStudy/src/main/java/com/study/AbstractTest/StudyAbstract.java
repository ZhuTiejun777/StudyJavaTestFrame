package com.study.AbstractTest;

// abstract 定义抽象类，抽象类需要子类继承后重写抽象方法
// 抽象类无法被实例化，抽象类中可以有具体的方法
// 抽象类的作用（类似定义规则）
// 抽象类被子类继承，无需将抽象类中的放法全部实现（区别于接口类）
// 如果一个子类实现了父类（抽象类）的所有抽象方法，那么该子类可以不必是抽象类，否则就是抽象类
// 抽象类中的抽象方法只有方法体，没有具体实现；
// 一个类只能继承一个抽象类，区别于接口
abstract public class StudyAbstract {
    abstract public int getAge();
}
