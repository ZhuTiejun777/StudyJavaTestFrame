package TeaseOutKnowledge.seventeenth;

import java.util.TreeSet;

/**
 * 使用元素的自然顺序对元素进行排序
 * 或者根据创建 set 时提供的 Comparator 进行排序
 *      所以排序有两种方式
 *          自然排序
 *          比较器排序
 * 具体取决于使用的构造方法。
 * TreeSet是如何保证元素的排序和唯一性的
 *      底层数据结构是红黑树(红黑树是一种自平衡的二叉树)
 */

public class TreeSetDemo {

    public static void main(String[] args) {
        // 创建集合对象
        // 自然顺序进行排序
        TreeSet<Integer> ts = new TreeSet<Integer>();

        // 创建元素并添加
        // 20,18,23,22,17,24,19,18,24
        ts.add(20);
        ts.add(18);
        ts.add(23);
        ts.add(22);
        ts.add(17);
        ts.add(24);
        ts.add(19);
        ts.add(18);
        ts.add(24);

        // 遍历
        for (Integer i : ts) {
            System.out.println(i);
        }
    }

}
