package TeaseOutKnowledge.sixteenth;

/**
 * 把泛型定义在接口上
 * 格式:public interface 接口名<泛型类型1…>
 */
public class InterDemo {

    public static void main(String[] args) {
        InterImpl1 interImpl1 = new InterImpl1();
        interImpl1.show("test");

        InterImpl2<String> interImpl2 = new InterImpl2<String>();
        interImpl2.show("test");


    }
}

