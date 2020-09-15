package JavaExercise.ArrayDemo;

public class BubbleSortDemo {

    public static void sort(long arr[]) {
        long tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                //判断前面数据大小: 如果后面数据比前面数据还小
                if(arr[j] < arr[j - 1]) {
                    //进行交换
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }

    //打印数组显示
    public static void print(long arr[]) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length -1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println("]");
    }

}
