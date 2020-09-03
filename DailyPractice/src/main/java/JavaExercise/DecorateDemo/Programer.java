package JavaExercise.DecorateDemo;

public class Programer implements Coder{

    private Student student;

    public Programer (Student stu) {
        this.student = stu;
    }
    public void code () {
        student.code();
        System.out.println("C");
        System.out.println("C++");
    }
}
