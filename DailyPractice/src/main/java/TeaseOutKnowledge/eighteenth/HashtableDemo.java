package TeaseOutKnowledge.eighteenth;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * HashMap和Hashtable区别
 *      HashMap:线程不安全，效率高。允许null键和null值
 *      Hashtable:线程安全，效率低。不允许null键和null值
 */

public class HashtableDemo {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<String, String>();

        hashMap.put("android", "hello");
        hashMap.put(null, "world");
        hashMap.put("java", null);
        System.out.println(hashMap);

        Hashtable<String, String> hashtable = new Hashtable<String, String>();
        hashtable.put("android", "hello");
        hashtable.put(null, "world"); //NullPointerException
        hashtable.put("java", null); // NullPointerException
        System.out.println(hashtable);
    }
}
