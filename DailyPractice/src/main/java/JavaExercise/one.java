package JavaExercise;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class one {

    // final修饰的变量需要初始化

    public static void main(String[] args) {
        String string = "91 27 46 38 50";;
        String [] strings = string.split(" ");
        int [] ints = new int[strings.length];
        for(int i = 0 ; i < strings.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);  //将数字字符串转换成int类型
        }
        // 3.对arr2排序
        Arrays.sort(ints);
        // 4.遍历并输出
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0 ; i < ints.length; i++) {
            if(i == ints.length -1) {
                stringBuilder = stringBuilder.append(ints[i]);
            }else {
                stringBuilder = stringBuilder.append(ints[i] + " ");
            }
        }

        // 5. 输出字符串
        System.out.println(stringBuilder);
    }
}
