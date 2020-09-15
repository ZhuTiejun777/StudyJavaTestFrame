package JavaExercise.ArrayDemo;

public class InsertSortDemo {

    public static void sort(long[] arr) {
        long tmp = 0;

        for(int i = 1; i < arr.length; i++) {
            tmp = arr[i];
            int j = i;
            while(j > 0 && arr[j - 1] >= tmp) {
                // 整体右侧移动一个位置
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tmp;
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
