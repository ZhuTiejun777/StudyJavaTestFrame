package JavaExercise.SetDemo;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo1 {

    public static void main(String[] args) {

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();

        linkedHashSet.add("java");
        linkedHashSet.add("c++");
        linkedHashSet.add("java");
        linkedHashSet.add("python");
        linkedHashSet.add("python");

        System.out.println(linkedHashSet);

        for (String string : linkedHashSet) {
            System.out.println(string);
        }
    }
}
