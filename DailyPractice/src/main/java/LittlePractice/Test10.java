package LittlePractice;

import java.util.*;

/**
 * 定义一个泛型为String类型的List集合，统计该集合中每个字符（注意，不是字符串）出现的次数。
 * 例如：集合中有”abc”、”bcd”两个元素，程序最终输出结果为：“a = 1,b = 2,c = 2,d = 1”。
 */

public class Test10 {

    public static void main(String[] args)
    {
        List<String> list = new ArrayList<String>();
        list.add("abcd");
        list.add("adebc");
        list.add("sffa");
        Iterator iterator = list.iterator();
        String string = "";
        while(iterator.hasNext()) {
            string += (String)iterator.next();
            System.out.println(string);
        }
        getEachStrNum(string);
    }
    public static void getEachStrNum(String string)
    {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < string.length(); i++) {
            char s = string.charAt(i);
            if(map.containsKey(s)) {
                int num = map.get(s);
                map.put(s,num+1);
            } else {
                map.put(s, 1);
            }
        }
        Set<Map.Entry<Character,Integer>> charSet = map.entrySet();
        Iterator iterator = charSet.iterator();
        while(iterator.hasNext()) {
            Map.Entry<Character,Integer> entry = (Map.Entry<Character,Integer>)iterator.next();
            System.out.println(entry.getKey()+" = "+ entry.getValue());
        }
    }
}
