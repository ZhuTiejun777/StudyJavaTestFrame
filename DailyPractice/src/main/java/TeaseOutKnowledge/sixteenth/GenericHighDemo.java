package TeaseOutKnowledge.sixteenth;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 泛型通配符 < ?>
 *      任意类型，如果没有明确，那么就是Object以及任意的Java类了
 * ? extends E
 *      向下限定，E及其子类
 * ? super E
 *      向上限定，E及其父类
 */

public class GenericHighDemo {

    public static void main(String[] args) {
        // 泛型如果明确的写的时候，前后必须一致
        Collection<Object> collection1 = new ArrayList<Object>();

        // ?表示任意的类型都是可以的
        Collection<?> collection2 = new ArrayList<Integer>();
        Collection<?> collection3 = new ArrayList<Long>();
        Collection<?> collection4 = new ArrayList<Character>();
        Collection<?> collection5 = new ArrayList<Object>();

        // ? extends E:向下限定，E及其子类
        // Collection<? extends Animal> c9 = new ArrayList<Object>();//报错
        Collection<? extends Animal> c10 = new ArrayList<Animal>();
        Collection<? extends Animal> c11 = new ArrayList<Dog>();
        Collection<? extends Animal> c12 = new ArrayList<Cat>();

        // ? super E:向上限定，E极其父类
        Collection<? super Animal> c13 = new ArrayList<Object>();
        Collection<? super Animal> c14 = new ArrayList<Animal>();
        // Collection<? super Animal> c15 = new ArrayList<Dog>();//报错
        // Collection<? super Animal> c16 = new ArrayList<Cat>();//报错

    }
}
