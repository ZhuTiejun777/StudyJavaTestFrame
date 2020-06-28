package TeaseOutKnowledge.seventeenth;

import java.util.TreeSet;

/**
 * TreeSet集合保证元素排序和唯一性的原理
 * 唯一性：是根据比较的返回是否是0来决定。
 * 排序：
 *      A:自然排序(元素具备比较性)
 *          让元素所属的类实现自然排序接口 Comparable
 *      B:比较器排序(集合具备比较性)
 *          让集合的构造方法接收一个比较器接口的子类对象 Comparator
 */

// 需求：请按照姓名的长度排序
public class TreeSetDemo2 {

    public static void main(String[] args) {

        TreeSet<Animal> treeSet = new TreeSet<Animal>();

        // 创建元素
        Animal Animal1 = new Animal("狗", 22);
        Animal Animal2 = new Animal("狮子", 22);
        Animal Animal3 = new Animal("老虎", 21);
        Animal Animal4 = new Animal("猫", 22);
        Animal Animal5 = new Animal("老鼠", 55);
        Animal Animal6 = new Animal("大象", 34);
        Animal Animal7 = new Animal("熊猫", 33);
        Animal Animal8 = new Animal("狼", 23);

        // 添加元素
        treeSet.add(Animal1);
        treeSet.add(Animal2);
        treeSet.add(Animal3);
        treeSet.add(Animal4);
        treeSet.add(Animal5);
        treeSet.add(Animal6);
        treeSet.add(Animal7);
        treeSet.add(Animal8);

        // 遍历
        for (Animal s : treeSet) {
            System.out.println(s.getName() + "---" + s.getAge());
        }
    }
}
