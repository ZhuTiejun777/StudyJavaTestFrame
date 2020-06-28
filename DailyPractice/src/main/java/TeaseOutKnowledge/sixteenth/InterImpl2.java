package TeaseOutKnowledge.sixteenth;

//第二种情况：还不知道是什么类型的
public class InterImpl2<T> implements Inter<T>{

    public void show (T t) {
        System.out.println(t);
    }
}
