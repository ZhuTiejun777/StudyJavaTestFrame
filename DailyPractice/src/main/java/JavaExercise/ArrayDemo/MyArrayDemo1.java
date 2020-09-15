package JavaExercise.ArrayDemo;

public class MyArrayDemo1 {

    private long[] arr;
    // 表示数组长度
    // int 没有初始化,默认初始化值为0
    private int elements;

    public MyArrayDemo1() {
        // 默认长度
        arr = new long[50];
    }

    public MyArrayDemo1(int maxsize) {
        arr = new long[maxsize];
    }

    public void insert(long value) {
        arr[elements] = value;
        elements++;
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < elements; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    public int search(long value) {
        int i;
        for (i = 0; i < elements; i++) {
            if (value == arr[i]) {
                break; // 找到了就不再查了
            }
        }
        //做判断，考虑查不到就返回-1
        if (i == elements) {
            return -1;
        } else {
            return i;
        }
    }

    public long search(int index) {
        if (index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return arr[index];
        }
    }

    public void delete(int index) {
        if (index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            arr[index] = arr[index + 1];
        }
        elements--;
    }

    public void change(int index, long value) {
        if(index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            arr[index] = value;
        }
    }
}