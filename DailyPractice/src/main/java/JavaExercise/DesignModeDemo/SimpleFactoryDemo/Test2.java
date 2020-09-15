package JavaExercise.DesignModeDemo.SimpleFactoryDemo;

public class Test2 {

    public static void main(String[] args) {

        DogFactory dogFactory = new DogFactory();
        Dog dog = (Dog) dogFactory.createAnimal();
        dog.eat();

        CatFactory catFactory = new CatFactory();
        Cat cat = (Cat) catFactory.createAnimal();
        cat.eat();
    }
}
