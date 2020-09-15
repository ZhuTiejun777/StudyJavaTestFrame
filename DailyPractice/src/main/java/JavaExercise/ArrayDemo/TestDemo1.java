package JavaExercise.ArrayDemo;

public class TestDemo1 {

    public static void main(String[] args) {

        MyArrayDemo1 myArrayDemo1 = new MyArrayDemo1(3);

        myArrayDemo1.insert(1);
        myArrayDemo1.insert(10);
        myArrayDemo1.insert(100);
        myArrayDemo1.print();

        System.out.println(myArrayDemo1.search(2));
        System.out.println(myArrayDemo1.search(3));

        System.out.println(myArrayDemo1.search(100));
        System.out.println(myArrayDemo1.search(10));


    }
}
