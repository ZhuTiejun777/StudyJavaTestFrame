package TeaseOutKnowledge.nineteenth;

/**
 * 自定义异常测试类
 */

public class Teacher {

    public void check(int score) throws MyException{
        if (score > 100 || score < 0) {
            throw new MyException("分数必须在0-100之间");
        } else {
            System.out.println("分数没有问题");
        }
    }
}
