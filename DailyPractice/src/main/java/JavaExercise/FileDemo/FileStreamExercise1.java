package JavaExercise.FileDemo;

import java.io.*;
import java.util.Scanner;

public class FileStreamExercise1 {

    public static void main(String[] args) throws IOException {
        File file = getFile();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file.getName()));

        int x;
        while ((x = bufferedInputStream.read()) != -1) {
            bufferedOutputStream.write(x);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

    private static File getFile () throws IOException {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String line = scanner.nextLine();
            File file = new File(line);

            if(!file.exists()) {
                System.out.println("录入的文件对象不存在，请重新输入！");
            } else if (file.isDirectory()) {
                System.out.println("录入是一个文件夹，不是一个文件，请重新输入！");
            } else {
                return file;
            }
        }

    }
}
