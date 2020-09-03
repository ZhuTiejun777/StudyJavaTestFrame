package JavaExercise.FileDemo;

import java.io.*;
import java.util.Scanner;

public class FileStreamExercise2 {

    public static void main(String[] args) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(".//test.txt"), true));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String string = scanner.nextLine();
            if (string.equals("quit")) {
                break;
            } else {
                bufferedOutputStream.write(string.getBytes());
                bufferedOutputStream.write("\r\n".getBytes());
            }
        }

        bufferedOutputStream.close();
    }

}
