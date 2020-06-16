package TeaseOutKnowledge.fourteenth;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List接口概述
 *      有序的 collection（也称为序列）。此接口的用户可以对列表中每个元素的插入位置进行精确地控制。
 *      用户可以根据元素的整数索引（在列表中的位置）访问元素，并搜索列表中的元素。
 *      与 set 不同，列表通常允许重复的元素。
 * List和Set的区别
 *      List接口：元素是有序的，元素可以重复，因为该集合体系有索引
 *      Set接口：元素是无序，元素不可以重复，不能索引
 * List接口成员方法
 *      添加功能
 *          void add(int index,Object element):在指定位置添加元素
 *      获取功能
 *          Object get(int index):获取指定位置的元素
 *      删除功能
 *          Object remove(int index)：根据索引删除元素,返回被删除的元素
 *      修改功能
 *          Object set(int index,Object element):根据索引修改元素，返回被修饰的元素
 */
public class ListDemo {

    public static void main(String[] args) {
        // 我们先创建集合对象
        List list = new ArrayList();
        // 添加元素
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println("原集合：" + list);

        //在指定位置添加元素
        list.add(1, "android");
        System.out.println("添加后：" + list);
        //list.add(11, "javaee");//这样会有问题，出现IndexOutOfBoundsException

        //获取指定位置的元素
        System.out.println("获取后:" + list.get(1));

        //根据索引删除元素,返回被删除的元素
        list.remove(1);
        System.out.println("删除后:" + list);

        //根据索引修改元素，返回被修饰的元素
        list.set(1, "javaee");
        System.out.println("修改后:" + list);

        // 获取所有元素
        for (int x = 0; x < list.size(); x++) {
            System.out.println(list.get(x));
        }

        // 通过迭代器
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println("next:" + it.next());
        }
    }
}
