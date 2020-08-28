package JavaExercise;

public class four {

    public static void main(String[] args) {
        System.out.println(testReturn(10));
        System.out.println(testReturn(1));
    }

    private static String testReturn (int num) {
        return (num >= 10) ? num + "" : num + "1";
    }
}
