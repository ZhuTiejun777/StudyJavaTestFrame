package TeaseOutKnowledge.seventeenth;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set
 *      元素是无序(存储顺序和取出顺序不一致),元素是唯一的，不可重复的
 */

public class SetDemo {

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        set.add("java");
        set.add("python");
        set.add("c++");
        set.add("javascript");
        set.add("shell");

        /**
         * 格式：
         *     for(元素数据类型 变量 : 数组或者Collection集合) {
         *         使用变量即可，该变量就是元素
         *     }
         */

        for (String str : set) {
            System.out.println(str);
        }

        System.out.println("------------------");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
