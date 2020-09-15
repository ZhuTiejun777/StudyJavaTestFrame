package JavaExercise.ArrayDemo;

public class SelectionSortDemo {

    public static void sort(long[] arr) {
        int k = 0;
        long tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            k = i;
            for (int j = i; j < arr.length; j++) {
                //k是指向最小的元素，发现如果还有比k还小，交换
                if( arr[j] < arr[k]) {
                    k = j;
                }
            }

            tmp = arr[i];
            arr[i] = arr[k];
            arr[k] = tmp;
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
