package TeaseOutKnowledge.ninth;

/**
 * 类 Object 是类层次结构的根类。
 * 每个类都使用 Object 作为超类。
 * 所有的类都直接或者间接的继承自Object类。
 *
 */

public class StudyObject {

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.hashCode()); // 366712642

        System.out.println(student.getClass().getName());////com.adu.Student

        System.out.println(student.toString());

        Student s1 = new Student("梅西", 30);
        Student s2 = new Student("梅西", 30);
        System.out.println(s1 == s2); // false
        Student s3 = s1;
        System.out.println(s1 == s3);// true
        System.out.println(s1.equals(s2));// true
        System.out.println(s1.equals(s1)); // true
        System.out.println(s1.equals(s3)); // true
        Student s4 = new Student("Messi",30);
        System.out.println(s1.equals(s4)); //false

        //创建学生对象
        Student ss = new Student();
        student.setName("CSDN");
        student.setAge(27);

        //克隆学生对象
        //Object obj = student.clone();
        //Student ss1 = (Student)obj;

        System.out.println(ss.getName()+"---"+ss.getAge());//CSDN---27
        //System.out.println(ss1.getName()+"---"+ss1.getAge());//CSDN---27
        //输出结果都在输出语句的后面，方便大家对应查看。

    }



}
