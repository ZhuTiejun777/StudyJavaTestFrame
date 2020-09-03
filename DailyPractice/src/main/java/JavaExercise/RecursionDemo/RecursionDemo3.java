package JavaExercise.RecursionDemo;

public class RecursionDemo3 {

    /**
     * 递归求出1000阶乘尾部和全部0的个数
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Fun(1000));
    }

    public static int Fun(int num) {
        if(num > 0 && num < 5) {
            return 0;
        }else {
            return num / 5 + Fun(num / 5);
        }
    }
}
