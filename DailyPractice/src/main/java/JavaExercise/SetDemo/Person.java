package JavaExercise.SetDemo;

public class Person {

    public Person () {
        super();
    }

    public Person (String name, int age) {
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

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;

    @Override
    public String toString () {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)					//调用的对象和传入的对象是同一个对象
            return true;					//直接返回true
        if (obj == null)					//传入对象为null
            return false;					//返回false
        if (getClass() != obj.getClass())	//判断两个对象对应的字节码文件是否是同一个字节码(Java中内存中不可能存在两个相同的字节码文件)
            return false;					//如果不是直接返回false
        Person other = (Person) obj;		//上面的可能都排除，只能是符合类型传入，做强制转换，向下转型
        if (age != other.age)				//调用对象的年龄不等于传入对象的年龄
            return false;					//返回false
        if (name == null) {					//调用对象的姓名为null
            if (other.name != null)			//调用对象的姓名为null
                return false;				//返回false
        } else if (!name.equals(other.name))//调用对象的姓名不等于传入对象的姓名
            return false;					//返回false
        return true;						//前面判断都经历了，返回true
    }

    //如果这里不重写父类的equals方法，集合中使用contains方法就无法去重
    /*@Override
    public boolean equals (Object object) {
        Person person = (Person) object;
        return this.name.equals(person.name) && this.age == person.age;
    }

    @Override
    public int hashCode () {
        //return super.hashCode();  //父类的hashCode方法
        return 10;					//重写，不使用hash算法直接指定hashCode值为10
    }*/
}
