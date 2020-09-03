package JavaExercise.CollectionsDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Landlords {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        for (int i = 1; i < 13; i ++) {
            list.add(String.valueOf(i) + "a");
            list.add(String.valueOf(i) + "b");
            list.add(String.valueOf(i) + "c");
            list.add(String.valueOf(i) + "d");
        }

        list.add("mixKing");
        list.add("maxKing");

        Collections.shuffle(list);

        System.out.println(list);
    }
}
