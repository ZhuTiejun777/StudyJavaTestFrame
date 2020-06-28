package TeaseOutKnowledge.seventeenth;

import java.util.HashSet;

public class HashSetDemo2 {

    public static void main(String[] args) {

        HashSet<Student> hashSet = new HashSet<Student>();

        // 需要实例化类赋值变量后才能,添加到列表中
        Student s1 = new Student("朱婷", 22);
        Student s2 = new Student("惠若琪", 22);
        Student s3 = new Student("徐云丽", 21);
        Student s4 = new Student("朱婷", 22);
        Student s5 = new Student("郎平", 55);
        Student s6 = new Student("郎平", 57);

        hashSet.add(s1);
        hashSet.add(s2);
        hashSet.add(s3);
        hashSet.add(s4);
        hashSet.add(s5);
        hashSet.add(s6);

        /**
         * 输出结果有重复的，
         * 因为HashSet底层依赖的是hashCode()和equals()方法。
         * 而这两个方法在学生类中没有重写，所以，默认使用的是Object类。
         * 这个时候，他们的哈希值是不会一样的，根本就不会继续判断，执行了添加操作
         */

        for (Student student : hashSet) {
            System.out.println("name:" + student.getName() + "\t" + "age:" + student.getAge());
        }

    }
}
