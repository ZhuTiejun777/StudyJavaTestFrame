package TeaseOutKnowledge.fifteenth;

import java.util.LinkedList;

/**
 * 添加功能
 *      public void addFirst(Object e)
 *      public void addLast(Object e)
 * 获取功能
 *      public Object getFirst()
 *      public Obejct getLast()
 * 删除功能
 *      public Object removeFirst()
 *      public Object removeLast()
 */

public class LinkedListDemo {

    public static void main(String[] args) {

        LinkedList linkedlist = new LinkedList();

        linkedlist.add("java");
        linkedlist.add("python");
        linkedlist.add("c++");

        linkedlist.addFirst("first");
        System.out.println("addfirst:" + linkedlist);
        linkedlist.addLast("last");
        System.out.println("addlast:" + linkedlist);

        System.out.println("getfirst:" + linkedlist.getFirst());
        System.out.println("getlast:" + linkedlist.getLast());

        System.out.println("removefirst:" + linkedlist.removeFirst());
        System.out.println("removelast:" + linkedlist.removeLast());

        System.out.println("link:" + linkedlist);
    }
}
