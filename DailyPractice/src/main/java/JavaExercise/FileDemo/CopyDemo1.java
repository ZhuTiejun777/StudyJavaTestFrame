package JavaExercise.FileDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo1 {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\git.png");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\copy.png");

        int x;

        while ((x = fileInputStream.read()) != -1) {
            fileOutputStream.write(x);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
