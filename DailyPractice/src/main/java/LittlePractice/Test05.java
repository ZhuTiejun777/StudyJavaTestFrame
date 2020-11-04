package LittlePractice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

/**
 * 双色球规则：双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。红色球号码从1—33中选择；
 * 蓝色球号码从1—16中选择；请随机生成一注双色球号码。（要求同色号码不重复）
 */

public class Test05 {

    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        int i = 0;
        while(i<6) {
            Random red = new Random();
            int redNum = red.nextInt(33) + 1;
            if(!hashSet.contains(redNum)) {
                hashSet.add(redNum);
                i++;
            }
        }
        boolean flag = true;
        while(flag) {
            Random blue = new Random();
            int blueNum = blue.nextInt(16) + 1;
            if(!hashSet.contains(blueNum)) {
                hashSet.add(blueNum);
                flag = false;
            }
        }
        Iterator it = hashSet.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
