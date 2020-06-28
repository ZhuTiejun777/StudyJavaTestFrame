package TeaseOutKnowledge.fourteenth;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ListIteratorDemo {

    public static void main(String[] args) {
        // 创建List集合对象
        List list = new ArrayList();
        // 添加元素
        list.add("hello");
        list.add("world");
        list.add("java");

        // 看到这里，我们会想到用我们上面学的迭代器遍历
        // 迭代器是依赖于集合而存在的，在判断成功后，集合的中新添加了元素，而迭代器却不知道，所以就报错了，这个错叫并发修改异常。
        // 迭代器遍历元素的时候，通过集合是不能修改元素的。
        // Iterator没有添加功能,需要调用它的子类ListIterator
        // Iterator iterator = list.iterator();
        ListIterator iterator = list.listIterator();
        while (iterator.hasNext()) {
            String s = (String) iterator.next();
            if ("world".equals(s)) {
                iterator.add("javaee");
            }
        }
        System.out.println("list:" + list);
    }
}
