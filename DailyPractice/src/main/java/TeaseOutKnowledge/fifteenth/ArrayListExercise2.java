package TeaseOutKnowledge.fifteenth;

import java.util.ArrayList;

/**
 * 不能创建新的集合，就在以前的集合上做修改
 */

public class ArrayListExercise2 {

    public static void main(String[] args) {
        // 创建集合对象
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

        for (int x = 0; x < array.size() - 1; x++) {
            for (int y = x + 1; y < array.size(); y++) {
                if (array.get(x).equals(array.get(y))) {
                    array.remove(y);
                    y--;
                }
            }
        }
        System.out.println(array);
    }
}
