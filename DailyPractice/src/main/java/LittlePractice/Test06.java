package LittlePractice;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 分别用Comparable和Comparator两个接口对下列四位同学的成绩做降序排序，如果成绩一样，那在成绩排序的基础上按照年龄由小到大排序。
 */
public class Test06 {

    public static void main(String[] args) {
        ArrayList<Student> arrayList = new ArrayList<Student>();
        arrayList.add(new Student("zhangsan", 25, 90.0F));
        arrayList.add(new Student("lisi", 22, 190.0F));
        arrayList.add(new Student("wangwu", 20, 90.0F));
        arrayList.add(new Student("sunliu", 22, 100.0F));

        Collections.sort(arrayList);

        for (Student student : arrayList) {
            System.out.println(student.getName());
        }
    }
}
