package JavaExercise.RecursionFileDemo;

import java.io.File;
import java.util.Scanner;

// 输入文件并打印文件下所有.png文件
public class RecursionFileDemo2 {

    public static void main(String[] args) {
        File file = getfile();
        printFileName(file);
    }

    private static void printFileName (File file) {
        File[] files = file.listFiles();
        for (File fi : files) {
            if (file.isFile() && (fi.getName().endsWith(".png"))) {
                System.out.println(fi.getName());
            }else if (fi.isDirectory()) {
                printFileName(fi);
            }
        }

    }

    private static File getfile () {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            File file = new File(scanner.nextLine());
            if (!file.exists()) {
                System.out.println("path is null");
            }else if (!file.isDirectory()) {
                System.out.println("path not directory");
            } else {
                return file;
            }
        }
    }
}
