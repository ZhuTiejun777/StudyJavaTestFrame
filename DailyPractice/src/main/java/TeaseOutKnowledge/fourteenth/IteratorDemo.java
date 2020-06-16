package TeaseOutKnowledge.fourteenth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Iterator接口概述
 *      对 collection 进行迭代的迭代器
 *      依赖于集合而存在
 * 成员方法
 *      boolean hasNext()
 *      next()
 */
public class IteratorDemo {
    public static void main(String[] args) {
        // 创建集合对象
        Collection c = new ArrayList();

        // 创建并添加元素
        c.add("hello");
        c.add("world");
        c.add("java");

        Iterator it = c.iterator(); // 实际返回的肯定是子类对象，这里是多态
        while (it.hasNext()) {
            String s = (String) it.next();
            System.out.println(s);
        }
    }

}
