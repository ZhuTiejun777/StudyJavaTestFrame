package LittlePractice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * 双色球规则：双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。红色球号码从1—33中选择；
 * 蓝色球号码从1—16中选择；请随机生成一注双色球号码。（要求同色号码不重复）
 */

public class Test04 {

    public static void main(String[] args) {
        final Random random = new Random();
        HashSet<HashMap<String, Integer>> hashSet = new HashSet<HashMap<String, Integer>>();
        while (hashSet.size() < 6) {
            HashMap<String, Integer> hashMap = new HashMap<String, Integer>()
            {
                {
                    this.put("red", random.nextInt(33) + 1);
                }
            };
            // hashMap.put("red", random.nextInt(32));
            hashSet.add(hashMap);
        }
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("blue", random.nextInt(17) + 1);
        hashSet.add(hashMap);
        System.out.println(hashSet);
    }
}
