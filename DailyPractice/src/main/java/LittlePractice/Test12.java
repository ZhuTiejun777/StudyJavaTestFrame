package LittlePractice;

import java.util.*;

public class Test12 {

    public static void main(String[] args) {
        // 1=朱辛庄、2=育知路、3=平西府、4=回龙观东大街、5=霍营、10=森林公园南门、6=育新、12=奥体中心、13=北土城
        // 将以上对应关系的数据存储到map集合中，key：表示站编号，value：表示站名，并遍历打印(可以不按顺序打印)
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
        linkedHashMap.put(1, "朱辛庄");
        linkedHashMap.put(2, "育知路");
        linkedHashMap.put(3, "平西府");
        linkedHashMap.put(4, "回龙观东大街");
        linkedHashMap.put(5, "霍营");
        linkedHashMap.put(6, "育新");
        linkedHashMap.put(10, "森林公园南门");
        linkedHashMap.put(12, "奥体中心");
        linkedHashMap.put(13, "北土城");
        for (Map.Entry<Integer, String> map : linkedHashMap.entrySet()) {
            System.out.println(map.getKey() + "---" + map.getValue());
        }
        // 打印格式（需要对键盘录入的上车站和到达站进行判断，如果没有该站，提示重新输入，直到站名存在为止）
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> hashMap = new HashMap<String, String>();
        while (true) {
            if (linkedHashMap.containsValue(scanner.nextLine())) {
                System.out.println("start point exist, input end point");
                hashMap.put("startPoint", scanner.nextLine());
                break;
            } else System.out.println("start point not exist, again input");
        }
        while (true) {
            if (linkedHashMap.containsValue(scanner.nextLine())) {
                System.out.println("end point exist");
                hashMap.put("endPoint", scanner.nextLine());
                break;
            } else System.out.println("end point not exist, again input");
        }
        System.out.println(hashMap);
    }

    private static Map<String , Integer> motroTicketAndTime (LinkedHashMap<Integer, String> linkedHashMap, HashMap<String, String> hashMap) {
        int startNumber = 0;
        int endNumber = 0;
        for (Integer integer : linkedHashMap.keySet()) {
            if (linkedHashMap.get(integer).equals(hashMap.get("startPoint"))) {
                startNumber = integer;
            }
            if (linkedHashMap.get(integer).equals(hashMap.get("endPoint"))) {
                endNumber = integer;
            }
        }
        int intervalNumber = Math.abs(startNumber - endNumber);
        HashMap<String, Integer> resultHashMap = new HashMap<String, Integer>();
        // 总行程 3站内（包含3站）收费3元，3站以上但不超过5站（包含5站）的收费4元，
        // 5站以上的，在4元的基础上，每多1站增加2元，10元封顶；
        // 注意：每站需要2分钟
        resultHashMap.put("time", intervalNumber * 2);
        if (intervalNumber <= 3) {
            resultHashMap.put("Ticket", 3);
        } else if (intervalNumber <= 5) {
            resultHashMap.put("Ticket", 4);
        } else {
            if (((intervalNumber - 5) * 2) >= 10) {
                resultHashMap.put("Ticket", 10);
            } else {
                resultHashMap.put("Ticket", 4 + (intervalNumber - 5) * 2);
            }
        }
        return resultHashMap;
    }
}
