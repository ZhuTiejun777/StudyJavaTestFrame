package TeaseOutKnowledge.eighth;

/**
 * 如何调用子类特有的成员变量和方法
 *      创建子类对象调用方法即可。(可以，但是很多时候不合理。而且，太占内存了)
 *      把父类的引用强制转换为子类的引用。(向下转型)
 *          向上转型
 *              从子到父
 *                  父类引用指向子类对象
 *                  Fu f = new Zi();
 *          向下转型
 *              从父到子
 *                  父类引用转为子类对象
 *                  Zi z = (Zi)f; //要求该f必须是能够转换为Zi的
 *
 */

public class StudyTransition {

    public static void main(String[] args) {
        // 向下转型 int 能转化为 double
        double num = (int)100;

        // 向上转型 父类引用指向子类对象
        // 实例化对象 physics1 以父类为基础 （Physics包含Subject）
        Subject physics1 = new Physics();
        physics1.grade();
        Physics.book();

        //关于向下转型，我们能够把子类的对象赋值给父类，
        //所以我们也可以把父类的引用赋值给子类的引用
        //Physics physics2 = (Physics) physics1;
        //Physics类包含physics1实例化对象，则可以向下转型
        Physics physics2 = (Physics) physics1;
        physics2.page();

    }
}
