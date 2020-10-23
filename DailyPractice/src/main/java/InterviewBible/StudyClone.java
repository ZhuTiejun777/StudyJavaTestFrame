package InterviewBible;

public class StudyClone {

    public static void main(String[] args) throws CloneNotSupportedException {

        Student student1 = new Student();
        student1.setName("zhangsan");
        student1.setAge(10);

        Student student2 =(Student) student1.clone();
        System.out.println(student2.getAge());

    }
}
