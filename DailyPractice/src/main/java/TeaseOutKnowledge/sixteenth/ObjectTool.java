package TeaseOutKnowledge.sixteenth;

// 泛型类
public class ObjectTool<T> {

    private T obj;

    public T getObj () {
        return obj;
    }

    public void setObj (T obj) {
        this.obj = obj;
    }

    // 泛型方法
    // <F> 修饰符,表示传入参数有泛型
    public <F> void show (F f) {
        System.out.println(f);
    }


}
