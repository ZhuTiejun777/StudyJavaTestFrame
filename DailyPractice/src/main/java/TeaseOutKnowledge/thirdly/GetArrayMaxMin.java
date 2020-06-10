package TeaseOutKnowledge.thirdly;

public class GetArrayMaxMin {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        System.out.println(getMax(arr));

        System.out.println(getMin(arr));

    }

    public static int getMax(int[] arr) {
        //从数组中任意的找一个元素作为参照物
        int max = arr[0];
        //然后遍历其他的元素
        for(int x=1; x<arr.length; x++) {
            //依次获取和参照物进行比较，如果大就留下来，如果小，就离开。
            if(arr[x] > max) {
                max = arr[x];
            }
        }
        //最后参照物里面保存的就是最大值。
        return max;
    }

    public static int getMin(int[] arr) {
        //从数组中任意的找一个元素作为参照物
        int min = arr[0];
        //然后遍历其他的元素
        for(int x=1; x<arr.length; x++) {
            //依次获取和参照物进行比较，如果小就留下来，如果大，就离开。
            if(arr[x] < min) {
                min = arr[x];
            }
        }
        //最后参照物里面保存的就是最小值。
        return min;
    }

}
