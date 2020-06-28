package TeaseOutKnowledge.sixteenth;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 泛型
 *      是一种把类型明确的工作推迟到创建对象或者调用方法的时候才去明确的特殊的类型。
 * 好处
 *      提高了程序的安全性
 *      把运行时期的问题提前到了编译期间
 *      避免了强制类型转换
 * 格式
 *      <数据类型>
 *      此处的数据类型只能是引用类型。
 */

public class GenericDemo {

    public static void main(String[] args) {

        ArrayList<String> array = new ArrayList<String>();

        array.add("java");
        array.add("python");
        array.add("c++");

        //添加int类型的元素 会报错
        // array.add(10); // JDK5以后的自动装箱
        // 等价于：array.add(Integer.valueOf(10));

        Iterator<String> it = array.iterator();
        while (it.hasNext()) {
            // ClassCastException
            // String s = (String) it.next();
            String s = it.next();
            System.out.println(s);
        }

    }
}
