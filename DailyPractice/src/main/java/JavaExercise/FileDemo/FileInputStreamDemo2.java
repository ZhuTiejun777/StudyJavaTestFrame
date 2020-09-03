package JavaExercise.FileDemo;

import TeaseOutKnowledge.twentyfirst.FileInputStreamDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo2 {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\abc.txt");
        int n;
        while ((n = fileInputStream.read()) != -1) {
            System.out.println(n);
        }
        fileInputStream.close();
    }
}
