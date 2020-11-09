package LittlePractice;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 从键盘获取一行输入字符串，要求去除重复字符。
 */
public class Test15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        HashSet<Character> hashSet = new HashSet<Character>();
        char[] chars = string.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (Character character : chars) {
            if (hashSet.add(character)) {
                stringBuffer.append(character);
            }
        }
        System.out.println(stringBuffer);

        /*for (int i = 0; i < string.length(); i ++) {
            hashSet.add(string.charAt(i));
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Character character : hashSet) {
            stringBuffer.append(character);
        }
        System.out.println(stringBuffer);*/
    }
}
