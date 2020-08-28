package JavaExercise.SetDemo;

import java.util.HashSet;
import java.util.Set;

public class HastSetDemo1 {

    public static void main(String[] args) {

        Set<String> set = new HashSet<String>();

        set.add("c++");
        set.add("python");
        set.add("java");
        // 向set中增加元素,如果元素存在则返回false
        System.out.println(set.add("java"));
        System.out.println(set);

        for (String string : set) {
            System.out.println(string);
        }
    }
}
