package InterviewBible;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        Map<Integer, User> hashMap = new HashMap<Integer, User>();
        hashMap.put(1, new User("zhangsan", 10));
        hashMap.put(2, new User("lisi", 15));
        hashMap.put(3, new User("wangwu", 20));

        System.out.println(hashMap);

        for (Map.Entry<Integer, User> map : hashMap.entrySet()) {
            System.out.println(map);
        }
    }
}
