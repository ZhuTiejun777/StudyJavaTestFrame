package JavaExercise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

// 抑制警告,抑制类型错误警告,抑制不受约束的警告
@SuppressWarnings({"rawtypes", "unchecked"})
public class five {

    public static void main(String[] args) {

        Collection c = new ArrayList();
        c.add("abc");
        c.add(100);
        c.add(true);
        c.add('y');
        //集合转数组
        Object[] arr = c.toArray();

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        Iterator iterator = c.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
