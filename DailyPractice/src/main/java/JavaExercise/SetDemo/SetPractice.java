package JavaExercise.SetDemo;

import java.util.*;

public class SetPractice {

    public static void main(String[] args) {

        setRandom(20, 10);

        setDistinct();

        ArrayList<String> list = new ArrayList<String>();
        list.add("java");
        list.add("c++");
        list.add("java");
        list.add("python");
        list.add("python");
        list.add("java");
        setList(list);
    }

    private static void setRandom (int num, int size) {
        // 生成10个1到20之间的不重复的随机数
        Set<Integer> set = new HashSet<Integer>();
        Random random = new Random();

        while (set.size() < size) {
            set.add(random.nextInt(num) + 1);
        }

        for (Integer integer : set) {
            System.out.println(integer);
        }
    }

    private static void setDistinct () {
        // 从键盘获取一行输入字符串，要求去除重复字符
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入字符串:");
        String strings = scanner.nextLine();

        Set<Character> set = new HashSet<Character>();

        char [] chars = strings.toCharArray();

        for (int i = 0; i < chars.length; i ++) {
            set.add(chars[i]);
        }

        //5.遍历HashSet集合
        for (Character character : set) {
            System.out.println(character);
        }
    }

    private static <T> void setList (ArrayList<T> list) {

        Set<T> set = new HashSet<T>();

        for (T t : list) {
            set.add(t);
        }

        for (T t : set) {
            System.out.println(t);
        }
    }
}
