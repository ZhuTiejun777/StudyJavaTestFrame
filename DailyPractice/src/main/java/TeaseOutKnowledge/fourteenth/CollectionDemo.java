package TeaseOutKnowledge.fourteenth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 概述（通过查看API）
 *      Collection 层次结构中的根接口。Collection 表示一组对象，这些对象也称为 collection 的元素。
 *      一些 collection 允许有重复的元素，而另一些则不允许。一些 collection 是有序的，而另一些则是无序的。
 * Collection的功能概述：
 *      1：添加功能
 *          boolean add(Object obj):添加一个元素
 *          boolean addAll(Collection c):添加一个集合的元素
 *      2:删除功能
 *          void clear():移除所有元素
 *          boolean remove(Object o):移除一个元素
 *          boolean removeAll(Collection c):移除一个集合的元素
 *      3:判断功能
 *          boolean contains(Object o)：判断集合中是否包含指定的元素
 *          boolean containsAll(Collection c)：判断集合中是否包含指定的集合元素
 *          boolean isEmpty()：判断集合是否为空
 *      4:获取功能
 *          Iterator iterator()
 *      5:长度功能
 *          int size():元素的个数
 *      6:交集功能
 *          boolean retainAll(Collection c)
 *      7：把集合转换为数组
 *          Object[] toArray()
 */

public class CollectionDemo {

    public static void main(String[] args) {
        // 测试不带All的方法

        // 创建集合对象
        // Collection c = new Collection(); //错误，因为接口不能实例化
        Collection c = new ArrayList();

        // boolean add(Object obj):添加一个元素
        c.add("hello");
        c.add("world");
        c.add("java");
        // boolean isEmpty()：判断集合是否为空
        System.out.println("isEmpty:"+c.isEmpty());

        //int size():元素的个数
        System.out.println("size:"+c.size());

        System.out.println("c:" + c);

        //我们还可以移除判断一下

        // void clear():移除所有元素
        c.clear();
        //要是移除了所有元素，上面的输出结果，isEmpty就成为true，size=0，c集合就为空[]

        // boolean remove(Object o):移除一个元素
        System.out.println("remove:" + c.remove("hello"));//上面我们给集合中add了hello，所以会返回true
        System.out.println("remove:" + c.remove("javaee"));//集合中没有javaee，所以肯定会返回false

        // boolean contains(Object o)：判断集合中是否包含指定的元素
        System.out.println("contains:"+c.contains("hello"));//和上面一样会返回true
        System.out.println("contains:"+c.contains("android"));//会返回false

        // 创建集合1
        Collection c1 = new ArrayList();
        c1.add("abc1");
        c1.add("abc2");

        // 创建集合2
        Collection c2 = new ArrayList();
        c2.add("abc1");
        c2.add("abc2");
        c2.add("abc3");
        c2.add("abc4");
        c2.add("abc5");

        c1.retainAll(c2);
        System.out.println("c1:" + c1);//c1:[abc1, abc2]
        System.out.println("c2:" + c2);//c2:[abc1, abc2, abc3, abc4, abc5]
// 创建集合对象
        Collection c3 = new ArrayList();

        // 添加元素
        c3.add("hello"); // Object obj = "hello"; 向上转型
        c3.add("world");
        c3.add("java");
        //遍历
        Object[] objs = c3.toArray();
        for (int x = 0; x < objs.length; x++) {
            String s = (String) objs[x];
            System.out.println(s + "---" + s.length());
        }
    }
}
