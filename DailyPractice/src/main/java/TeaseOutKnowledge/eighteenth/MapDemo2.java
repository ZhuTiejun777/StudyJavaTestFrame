package TeaseOutKnowledge.eighteenth;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 获取功能
 *      V get(Object key):根据键获取值
 *      Set keySet():获取集合中所有键的集合
 *      Collection values():获取集合中所有值的集合
 *      Set< Map.Entry< K,V>> entrySet()：返回的是键值对对象的集合
 */

public class MapDemo2 {

    public static void main(String[] args) {

        Map<String, String> map =new HashMap<String, String>();

        // 创建元素并添加元素
        map.put("邓超", "孙俪");
        map.put("黄晓明", "杨颖");
        map.put("周杰伦", "蔡依林");
        map.put("刘恺威", "杨幂");

        // V get(Object key):根据键获取值
        System.out.println("get:" + map.get("周杰伦"));
        System.out.println("get:" + map.get("周杰")); // 返回null

        // Set<K> keySet():获取集合中所有键的集合
        Set<String> set = map.keySet();
        for (String key : set) {
            System.out.println("key:"+key);
        }

        // Collection<V> values():获取集合中所有值的集合
        Collection<String> con = map.values();
        for (String value : con) {
            System.out.println("value:"+value);
        }
        // 获取所有键值对对象的集合
        Set<Map.Entry<String, String>> set1 = map.entrySet();
        // 遍历键值对对象的集合，得到每一个键值对对象
        for (Map.Entry<String, String> me : set1) {
            // 根据键值对对象获取键和值
            String key = me.getKey();
            String value = me.getValue();
            System.out.println(key + "---" + value);
        }
    }
}
