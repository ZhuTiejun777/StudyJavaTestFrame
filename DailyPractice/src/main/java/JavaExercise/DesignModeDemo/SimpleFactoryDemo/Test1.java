package JavaExercise.DesignModeDemo.SimpleFactoryDemo;

public class Test1 {

    public static void main(String[] args) {
        Dog dog = AnimalFactory.createDog();
        dog.eat();
        Cat cat = AnimalFactory.createCat();
        cat.eat();
        Animal animal = AnimalFactory.create("dog");
        animal.eat();
        Cat cats = (Cat) AnimalFactory.create("cat");
        cats.eat();
    }
}
