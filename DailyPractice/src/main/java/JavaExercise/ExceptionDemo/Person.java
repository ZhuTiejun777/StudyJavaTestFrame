package JavaExercise.ExceptionDemo;

public class Person {
    private String name;
    private int age;


    public Person() {
        super();

    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
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

    public void setAge(int age){
        if(age>0 && age < 150) {
            this.age = age;
        } else {
            throw new RuntimeException("年龄非法");
        }

    }

}
