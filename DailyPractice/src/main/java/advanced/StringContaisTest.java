package advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 元素去重
 */
public class StringContaisTest {

    public static void main(String[] args) {

        String[] A = {"a","dc","a","56","ab","a","56","ba","NBA","b"};

        List<String> list = new ArrayList<String>();

        for (String str : A) {
            if(!list.contains(str)) {
                list.add(str);
            }
        }

        System.out.println(list);

        //创建一个treeset对象
        TreeSet<String> ts = new TreeSet<String>();

        for(int i=0; i<A.length; i++){
            ts.add(A[i]);
        }

        System.out.println(ts);

    }
}
