package JavaExercise.SetDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class TreeSetDemo2 {

    public static void main(String[] args) {

        String input = null;
        //List<String> list = new ArrayList<String>();
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            input = scanner.nextLine();
            if (input.equals("quit")) {
                break;
            }
            treeSet.add(Integer.parseInt(input));
        }
        System.out.println(treeSet);
    }
}
