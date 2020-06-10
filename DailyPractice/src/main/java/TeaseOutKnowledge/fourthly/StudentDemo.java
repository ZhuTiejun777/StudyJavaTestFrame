package TeaseOutKnowledge.fourthly;

public class StudentDemo {

    public static void main(String[] args) {
        Student student = new Student();
        student.study();
        // 赋值给age变量值
        student.setAge(5);
        // 去除age变量的值
        System.out.println(student.getAge());
        student.setName();
        //System.out.println(student.name);
    }
}
