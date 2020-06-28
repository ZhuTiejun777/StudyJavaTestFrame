package TeaseOutKnowledge.eighteenth;

import java.util.HashMap;
import java.util.Map;

/**
 * Map集合的数据结构值针对键有效，跟值无关
 * Collection集合的数据结构是针对元素有效
 *
 * 添加功能
 *      V put(K key,V value):添加元素
 *
 * 删除功能
 *      void clear():移除所有的键值对元素
 *      V remove(Object key)：根据键删除键值对元素，并把值返回
 *
 * 判断功能
 *      boolean containsKey(Object key)：判断集合是否包含指定的键
 *      boolean containsValue(Object value):判断集合是否包含指定的值
 *      boolean isEmpty()：判断集合是否为空
 *
 * 长度功能
 *      int size()：返回集合中的键值对的对数
 */

public class MapDemo1 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();

        // 如果键是第一次存储，就直接存储元素，返回null
        System.out.println("put:" + map.put("key", "value"));
        // 如果键不是第一次存在，就用值把以前的值替换掉，返回以前的值
        System.out.println("put:" + map.put("key", "key"));
        map.put("value", "key");

        System.out.println("map" + map);

        // 移除所有元素
        // map.clear();

        //V remove(Object key)：根据键删除键值对元素，并把值返回
        System.out.println("remove:" + map.remove("key"));
        System.out.println("remove:" + map.remove("key"));
        // 输出集合名称
        System.out.println("map:" + map);

        //boolean containsKey(Object key)：判断集合是否包含指定的键
        System.out.println("containsKey:" + map.containsKey("key"));
        System.out.println("containsValue:" + map.containsValue("key"));
        // 输出集合名称
        System.out.println("map:" + map);
        //boolean isEmpty()：判断集合是否为空
        System.out.println("isEmpty:" + map.isEmpty());

        System.out.println("size:" + map.size());


    }
}
