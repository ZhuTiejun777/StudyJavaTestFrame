package TeaseOutKnowledge.sixteenth;

// 实现类在实现接口的时候，我们会遇到两种情况
// 第一种情况：已经知道是什么类型的了
public class InterImpl1 implements Inter<String>{

    public void show (String str) {
        System.out.println(str);
    }


}
