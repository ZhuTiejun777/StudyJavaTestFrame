package JavaExercise.RecursionDemo;

public class RecursionDemo1 {

    public static void main(String[] args) {
        System.out.println(getRabbitNumber1(10));
        System.out.println(getRabbitNumber1(2));
        System.out.println(getRabbitNumber2(10));
        System.out.println(getRabbitNumber2(2));
    }

    private static int getRabbitNumber1 (int num) {
        if (num == 2 || num == 1) {
            return 1;
        } else {
            return getRabbitNumber1(num - 2) + getRabbitNumber1(num - 1);
        }
    }

    private static int getRabbitNumber2 (int num) {
        int[] arr = new int[num];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < num; i ++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[num - 1];
    }
}
