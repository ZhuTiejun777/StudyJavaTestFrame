package JavaExercise.MapDemo;

import java.util.ArrayList;
import java.util.HashMap;

public class MapDemo1 {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("java");
        System.out.println(arrayList.isEmpty());

        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        // put函数,用value的数据类型接收,如果key存在则替换并返回原来key对应的value,不存在返回null
        Integer integer1 = hashMap.put("zhangsan", 23);
        Integer integer2 = hashMap.put("lisi", 24);
        Integer integer3 = hashMap.put("zhangsan", 25);
        System.out.println(integer1);
        System.out.println(integer2);
        System.out.println(integer3);
        System.out.println(hashMap);

        Integer integer4 = hashMap.remove("zhangsan");
        System.out.println(integer4);

        for (String string : hashMap.keySet()) {
            System.out.println(string + " = " + hashMap.get(string));
        }
    }
}
