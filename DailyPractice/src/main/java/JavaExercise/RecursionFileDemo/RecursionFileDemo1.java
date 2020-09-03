package JavaExercise.RecursionFileDemo;

public class RecursionFileDemo1 {

    public static void main(String[] args) {
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(fun(3));
        System.out.println(fun(5));
    }

    private static int factorial (int x) {
        int num = 1;
        for (int i = x; i > 0; i --) {
            num *= i;
        }
        return num;
    }

    private static int fun (int x) {
        if (x == 1) {
            return 1;
        } else {
            return x * fun(x - 1);
        }
    }
}
