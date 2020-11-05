package LittlePractice;

import java.util.HashMap;
import java.util.Map;

/**
 * 现在有一个map集合如下：
 * Map<Integer,String> map = new HashMap<Integer, String>();
 * map.put(1, “张三丰”);
 * map.put(2, “周芷若”);
 * map.put(3, “汪峰”);
 * map.put(4, “灭绝师太”);
 * 要求：
 * 1.遍历集合，并将序号与对应人名打印。
 * 2.向该map集合中插入一个编码为5姓名为李晓红的信息
 * 3.移除该map中的编号为1的信息
 * 4.将map集合中编号为2的姓名信息修改为"周林"
 */
public class Test07 {

    public static void main(String[] args) {

        Map<Integer, String> maps = new HashMap<Integer, String>();
        maps.put(1, "张三丰");
        maps.put(2, "周芷若");
        maps.put(3, "汪峰");
        maps.put(4, "灭绝师太");

        for (Map.Entry<Integer, String> map : maps.entrySet()) {
            System.out.println(map.getKey() + "---" + map.getValue());
        }

        maps.put(5, "李晓红");

        maps.remove(1);

        maps.put(2, "周林");

        for (Integer integer : maps.keySet()) {
            System.out.println(integer + "---" + maps.get(integer));
        }

    }
}
