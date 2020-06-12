package TeaseOutKnowledge.eleventh;

import java.util.ArrayList;
import java.util.List;

/**
 * 把字符串中的字符进行排序。举例：”dacgebf”。结果：”abcdefg”
 */

public class ArrayDemo2 {

    public static void main(String[] args) {

        String str = "dacgebf";
        // toCharArray() 将字符串转化为字符数组
        char[] cha = str.toCharArray();
        /*System.out.println(cha);
        for (int i = 0; i < cha.length; i ++ ) {
            System.out.println(cha[i]);
        }*/
        bubbleSort(cha);
        //把排序后的字符数组转成字符串
        String result = new String(cha);
        System.out.println(cha.getClass().toString());
        System.out.println(cha.getClass().getName());
        //输出最后的字符串
        System.out.println("result:"+result);
        System.out.println(result.getClass().toString());

        /*ArrayList<String> list = new ArrayList<String>();
        for (int num = 0; num < str.length(); num ++) {
            System.out.println();
        }*/

        List<String> list1 = new ArrayList<String>();
        list1.add("ss");
        System.out.println(list1);
    }

    // 冒泡排序
    public static void bubbleSort(char[] chs) {
        for (int x = 0; x < chs.length - 1; x++) {
            for (int y = 0; y < chs.length - 1 - x; y++) {
                if (chs[y] > chs[y + 1]) {
                    char temp = chs[y];
                    chs[y] = chs[y + 1];
                    chs[y + 1] = temp;
                }
            }
        }
    }
}
