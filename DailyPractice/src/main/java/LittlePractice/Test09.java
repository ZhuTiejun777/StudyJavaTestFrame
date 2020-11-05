package LittlePractice;

import java.util.*;

/**
 * 定义一个泛型为String类型的List集合，统计该集合中每个字符（注意，不是字符串）出现的次数。
 * 例如：集合中有”abc”、”bcd”两个元素，程序最终输出结果为：“a = 1,b = 2,c = 2,d = 1”。
 */

public class Test09 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("abc");
        list.add("bcd");
        ArrayList<String> strings = new ArrayList<String>();
        for (String string : list) {
            char[] chars = string.toCharArray();
            for (char c : chars) {
                strings.add(String.valueOf(c));
            }
        }
        System.out.println(strings);
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (String string : strings) {
            if (hashMap.containsKey(string)) {
                hashMap.put(string, hashMap.get(string) + 1);
            } else {
                hashMap.put(string, 1);
            }
        }
        for (Map.Entry<String, Integer> map : hashMap.entrySet()) {
            System.out.println(map.getKey() + "---" + map.getValue());
        }
    }
}
