package TeaseOutKnowledge.fifteenth;

import java.util.ArrayList;

/**
 * ArrayList去除集合中字符串的重复值(字符串的内容相同)
 */

public class ArrayListExercise1 {

    public static void main(String[] args) {

        ArrayList<String> array = new ArrayList<String>();

        // 添加多个字符串元素(包含内容相同的)
        array.add("hello");
        array.add("world");
        array.add("java");
        array.add("world");
        array.add("java");
        array.add("world");
        array.add("world");
        array.add("world");
        array.add("world");
        array.add("java");
        array.add("world");

        ArrayList<String> arrayList = new ArrayList<String>();

        for (int i = 0; i < array.size(); i ++) {
            if (!arrayList.contains(array.get(i))) {
                arrayList.add(array.get(i));
            }
        }
        System.out.println(arrayList);

    }
}
