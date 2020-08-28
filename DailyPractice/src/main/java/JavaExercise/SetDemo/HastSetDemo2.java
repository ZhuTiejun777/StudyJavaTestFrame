package JavaExercise.SetDemo;

import java.util.HashSet;

public class HastSetDemo2 {

    public static void main(String[] args) {

        HashSet<Person> hashSet = new HashSet<Person>();
        hashSet.add(new Person("张三",23));
        hashSet.add(new Person("张三",23));
        hashSet.add(new Person("李四",24));
        hashSet.add(new Person("李四",24));
        hashSet.add(new Person("王五",25));
        hashSet.add(new Person("王五",25));

        System.out.println(hashSet);
    }
}
