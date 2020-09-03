package JavaExercise.ExceptionDemo;

public class ExceptionDemo1 {

    public static void main(String[] args) {


        try{

            int[] arr = {11,22,33};
            //int x = div(10,0);
            //System.out.println(x);
            System.out.println(arr[5]);

        } catch(ArithmeticException a) {
            System.out.println("除数为零！");
        } catch(ArrayIndexOutOfBoundsException a) {
            System.out.println("数组索引越界了");
        } catch(Exception e) {
            System.out.println("出错了");
        }

    }

    public static int div(int a, int b) {
        return a / b;
    }

}
