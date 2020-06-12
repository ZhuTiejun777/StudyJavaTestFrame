package TeaseOutKnowledge.ninth;

public class Student extends Object{
    private String name;

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

    private int age;

    public Student () {
        super();
    }

    public Student (String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

}
