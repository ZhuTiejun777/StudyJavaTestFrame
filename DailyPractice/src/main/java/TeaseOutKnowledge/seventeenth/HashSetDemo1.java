package TeaseOutKnowledge.seventeenth;

import java.util.HashSet;

/**
 * HashSet类概述
 *      不保证 set 的迭代顺序
 *      特别是它不保证该顺序恒久不变。
 * HashSet如何保证元素唯一性
 *      底层数据结构是哈希表(元素是链表的数组)
 *      哈希表依赖于哈希值存储
 *      添加功能底层依赖两个方法：
 *          int hashCode()
 *          boolean equals(Object obj)
 */

public class HashSetDemo1 {

    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<String>();

        /**
         * add方法的源码，调用两个方法：hashCode()和equals()。
         * 步骤：
         *      首先比较哈希值
         *      如果相同，继续走，比较地址值或者走equals()
         *      如果不同,就直接添加到集合中
         * 按照方法的步骤来说：
         *      先看hashCode()值是否相同
         *      相同:继续走equals()方法
         *      返回true： 说明元素重复，就不添加
         *      返回false：说明元素不重复，就添加到集合
         *      不同：就直接把元素添加到集合
         * 如果类没有重写这两个方法，默认使用的Object()。一般来说不同相同。
         * 而String类重写了hashCode()和equals()方法，所以，它就可以把内容相同的字符串去掉。只留下一个。
         */

        hashSet.add("java");
        hashSet.add("python");
        hashSet.add("c++");

        for (String str : hashSet) {
            System.out.println(str);
            System.out.println(str.equals("java"));
        }
    }
}
