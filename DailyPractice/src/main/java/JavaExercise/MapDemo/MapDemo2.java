package JavaExercise.MapDemo;

import java.util.HashMap;
import java.util.Map;

public class MapDemo2 {

    public static void main(String[] args) {

        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

        hashMap.put("张三", 23);
        hashMap.put("李四", 24);
        hashMap.put("王五", 25);
        hashMap.put("赵六", 26);

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " + " + entry.getValue());
        }
        // HashMap可以存储null
        hashMap.put(null, 0);
        hashMap.put("test", null);
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " + " + entry.getValue());
        }
    }
}
