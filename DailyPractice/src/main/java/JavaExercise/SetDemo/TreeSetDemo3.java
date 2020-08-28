package JavaExercise.SetDemo;

import java.util.*;

public class TreeSetDemo3 {

    public static void main(String[] args) {

        String string = null;
        Scanner scanner = new Scanner(System.in);
        TreeSet<Student> treeSet = new TreeSet<Student>(new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                //降序
                int num = o1.getTotalGrade() - o2.getTotalGrade();
                return num == 0? 1 : num;  //总分成绩相同的也需要存入集合
            }
        });

        while (treeSet.size() < 3) {
            string = scanner.nextLine();
            String [] strings = string.split(",");
            int chinese = Integer.parseInt(strings[1]);
            int math = Integer.parseInt(strings[2]);
            int english = Integer.parseInt(strings[3]);
            treeSet.add(new Student(strings[0], chinese, math, english));
        }
        for (Student student : treeSet) {
            System.out.println(student);
        }
    }
}
