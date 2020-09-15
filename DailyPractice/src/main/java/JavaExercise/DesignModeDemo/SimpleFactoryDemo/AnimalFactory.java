package JavaExercise.DesignModeDemo.SimpleFactoryDemo;

public class AnimalFactory {

    public static Cat createCat () {
        return new Cat();
    }

    public static Dog createDog () {
        return new Dog();
    }

    public static Animal create(String name) {
        if("dog".equals(name)) {
            return new Dog();
        }else if("cat".equals(name)) {
            return new Cat();
        }else {
            return null;
        }
    }

}
