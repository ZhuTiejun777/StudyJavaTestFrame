package JavaExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        // 添加元素
        list.add("one");
        list.add("two");
        list.add("three");
        list.add(0, "four");
        System.out.println(list);
        // 删除元素
        list.remove(3);
        System.out.println(list);
        // 获取元素
        System.out.println(list.get(2));
        // 更改元素
        list.set(1, "five");
        System.out.println(list);

        // 迭代器,迭代时可以更改List
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        // 获取到world 更改为java
        List<String> lists= new ArrayList<String>();
        lists.add("a");
        lists.add("b");
        lists.add("world");
        lists.add("c");
        lists.add("d");
        for (int i = 0; i < lists.size(); i ++) {
            if (lists.get(i).equals("world")) {
                lists.set(i ,"java");
            }
        }
        System.out.println(lists);

     }
}
