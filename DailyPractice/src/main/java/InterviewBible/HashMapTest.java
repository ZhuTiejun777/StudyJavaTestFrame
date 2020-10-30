package InterviewBible;

import java.util.*;

public class HashMapTest {

    public static void main(String[] args) {
        HashMap<Integer, User> hashMap = new HashMap<Integer, User>();
        hashMap.put(1, new User("zhangsan", 10));
        hashMap.put(3, new User("lisi", 15));
        hashMap.put(2, new User("wangwu", 20));
        System.out.println(hashMap);
        HashMap<Integer, User> sortHashMap = sortHashMap(hashMap);
        System.out.println(sortHashMap);
    }

    private static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> hashMap) {
        Set<Map.Entry<Integer, User>> entrySet = hashMap.entrySet();
        List<Map.Entry<Integer, User>> list = new ArrayList<Map.Entry<Integer, User>>(entrySet);
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o1.getValue().getAge() - o2.getValue().getAge();
            }
        });
        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<Integer, User>();
        for (Map.Entry<Integer, User> entry : list) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }
}
