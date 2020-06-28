package TeaseOutKnowledge.fifteenth;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        list.add("111");
        list.add("222");
        list.add("333");

        // 迭代器返回的是类属性元素
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String string = (String) iterator.next();
            System.out.println(string);
        }
        System.out.println("----------");

        for (int i = 0; i < list.size(); i ++) {
            System.out.println(list.get(i));
        }
    }
}
