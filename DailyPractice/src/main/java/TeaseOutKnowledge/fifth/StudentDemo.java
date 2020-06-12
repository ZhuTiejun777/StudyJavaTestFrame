package TeaseOutKnowledge.fifth;

public class StudentDemo {

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.num1);
        // 非静态变量,类名.变量 无法调用
        // System.out.println(Student.num1);
        // 静态变量,对象名.变量 调用可以,但不推荐,最好直接 类名.变量名 调用
        // System.out.println(student.num2);
        System.out.println(Student.num2);

    }
}
