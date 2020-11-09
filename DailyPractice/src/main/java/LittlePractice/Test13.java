package LittlePractice;

public class Test13 {

    public static void main(String[] args) {

        ifTest(5);
        ifTest(3);
    }

    private static void ifTest (int i) {
        if (i <= 3) {
            System.out.println("one");
        } else if (i > 3 & i <= 5) {
            System.out.println("two");
        } else {
            System.out.println("three");
        }
    }
}
