package JavaExercise.SetDemo;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo1 {

    public static void main(String[] args) {

        Set<Integer> set = new TreeSet<Integer>();
        set.add(153);
        set.add(113);
        set.add(123);
        set.add(112);
        System.out.println(set);

        // 需要重写compareTo方法
        /*TreeSet<Person> treeSet = new TreeSet<Person>();
        treeSet.add(new Person("张飞", 25));
        treeSet.add(new Person("关羽", 26));
        treeSet.add(new Person("刘备", 27));
        System.out.println(treeSet);*/
    }
}
