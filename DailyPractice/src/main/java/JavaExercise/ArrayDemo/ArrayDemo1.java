package JavaExercise.ArrayDemo;

public class ArrayDemo1 {

    public static void main(String[] args) {

        // 创建数组格式： 类型[] 数组名称 = new 类型[初始大小]
        int[] ints = new int[10];
        ints[1] = 0;
        System.out.println(ints[1]);

        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(arr[2]);
    }
}
