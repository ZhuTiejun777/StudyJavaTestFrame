package LittlePractice;

import java.util.*;

/**
 * 一、利用Map，完成下面的功能：
 * 从命令行读入一个字符串，表示一个年份，输出该年的世界杯冠军是哪支球队。如果该 年没有举办世界杯，则输出：没有举办世界杯。
 * 二、在原有世界杯Map 的基础上，增加如下功能： 读入一支球队的名字，输出该球队夺冠的年份列表。
 * 例如，读入“巴西”，应当输出 1958 1962 1970 1994 2002 读入“荷兰”，应当输出 没有获得过世界杯
 */

public class Test11 {

    public static void main(String[] args)
    {
        HashMap<Integer,String> map = new HashMap<Integer,String>();
        map.put(1930,"乌拉圭");
        map.put(1934,"意大利");
        map.put(1938,"意大利");
        map.put(1950,"乌拉圭");
        map.put(1954,"西德");
        map.put(1958,"巴西");
        map.put(1962,"巴西");
        map.put(1966,"英格兰");
        map.put(1970,"巴西");
        map.put(1974,"西德");
        map.put(1978,"阿根廷");
        map.put(1982,"意大利");
        map.put(1986,"阿根廷");
        map.put(1990,"西德");
        map.put(1994,"巴西");
        map.put(1998,"法国");
        map.put(2002,"巴西");
        map.put(2006,"意大利");
        map.put(2010,"西班牙");
        map.put(2014,"德国");
        System.out.println("请输入年份:");
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry<Integer,String> entry = (Map.Entry<Integer,String>) iterator.next();
            if(entry.getKey()==inputNum) {
                System.out.println(entry.getKey()+"年获得世界杯冠军的是:"+entry.getValue());
            }
        }
        String temp = sc.nextLine();
        System.out.println("请输入国家名称");
        String inputStr = sc.nextLine();
        // Set<Map.Entry<Integer,String>>  set1 = map.entrySet();
        Iterator it1 = set.iterator();
        System.out.print("获得冠军的年份有：");
        int flag = 0;
        while(it1.hasNext()) {
            Map.Entry<Integer,String> entry1 = (Map.Entry<Integer,String>)it1.next();
            if(entry1.getValue().equals(inputStr)) {
                System.out.print(entry1.getKey()+" ");
                flag++;
            }
        }
        if(flag==0) {
            System.out.println("没有获得过世界杯");
        }
    }
}
