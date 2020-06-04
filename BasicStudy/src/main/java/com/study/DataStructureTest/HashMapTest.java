package com.study.DataStructureTest;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Set集合中不能有相同的元素,元素是无序的
 * HashSet集合元素值可以是null
 *
 *
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashSet<String> name = new HashSet<String>();
        name.add("Anthony");
        name.add("mark");
        name.add("tom");
        name.add("john");
        name.add("jack");

        // Iterator迭代器,将列表一类的数据类型变成循环模式
        Iterator<String> itr = name.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        Student s1 = new Student("小龙女", 23);
        Student s2 = new Student("任盈盈", 24);
        Student s3 = new Student("小龙女", 23);
        Student s4 = new Student("东方不败", 25);
        Student s5 = new Student("伊琳", 29);
        Student s6 = new Student("周芷若", 30);
        HashSet<Student> hashSet = new HashSet<Student>();
        hashSet.add(s1);
        hashSet.add(s2);
        hashSet.add(s3);
        hashSet.add(s4);
        hashSet.add(s5);
        hashSet.add(s6);
        for (Student student : hashSet) {
            // HashSet中数据类型是类方法,需要通过get类变量方法获取对应的值
            // 获取到的同一类中的元素,位置相等,值不相等
            System.out.println(student.getName()+"=="+student.getAge());
        }

        // 判断集合中是否包含某一个元素
        System.out.println(hashSet.contains(new Student("小龙女", 23)));
        // 判断集合是否为空
        System.out.println(hashSet.isEmpty());
        // 从集合中去掉特定的对象
        hashSet.remove(new Student("小龙女", 23));
        // 返回集合的大小
        System.out.println(hashSet.size());
        // 去掉集合中所有的元素
        hashSet.clear();
    }
}

