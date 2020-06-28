package TeaseOutKnowledge.fifteenth;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 添加功能
 *      public void addElement(Object obj)
 * 获取功能
 *      public Object elementAt(int index)
 *      public Enumeration elements()
 */

public class VectorDemo {

    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.addElement("java");
        vector.addElement("python");
        vector.addElement("c++");

        for (int i = 0; i < vector.size(); i ++) {
            String str = (String) vector.elementAt(i);
            System.out.println(vector.elementAt(i));
            System.out.println(str);
        }

        System.out.println("----------");

        Enumeration enumeration = vector.elements();

        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.hasMoreElements());
            String str = (String) enumeration.nextElement();
            System.out.println(str);
        }

    }
}
