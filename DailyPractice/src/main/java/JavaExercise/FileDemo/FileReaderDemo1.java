package JavaExercise.FileDemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo1 {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\Administrator\\Desktop\\abc.txt");

        int x;
        while ((x = fileReader.read()) != -1) {
            System.out.println((char) x);
        }
        fileReader.close();
    }
}
