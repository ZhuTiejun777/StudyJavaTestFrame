package LittlePractice;

public class Student implements Comparable<Student>{

    private String name;
    private int age;
    private float grade;

    public Student () {
        super();
    }

    public Student (String name, int age, float grade) {
        super();
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    // 根据返回值判断两值大小,负数-1(倒序)、0(相等)、正数(正序);
    @Override
    public int compareTo(Student other) {
        if (this.grade != other.grade) {
            return (int) (this.grade - other.grade);
        } else if (this.age != other.age) {
            return this.age - other.age;
        } else {
            return this.getName().compareTo(other.getName());
        }
    }
}
