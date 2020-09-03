package JavaExercise.CollectionsDemo;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsDemo {

    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<String>();
        strings.add("j");
        strings.add("f");
        strings.add("c");
        strings.add("p");

        // 排序之前
        System.out.println(strings);
        Collections.sort(strings);
        //排序之后
        System.out.println(strings);

        // 查找元素并返回索引,没有则返回-1
        System.out.println(Collections.binarySearch(strings, "a"));
        System.out.println(Collections.binarySearch(strings, "p"));
        System.out.println(Collections.binarySearch(strings, "f"));

        // 查找最大值
        System.out.println(Collections.max(strings));

        // 反转集合
        Collections.reverse(strings);
        System.out.println(strings);
    }
}
