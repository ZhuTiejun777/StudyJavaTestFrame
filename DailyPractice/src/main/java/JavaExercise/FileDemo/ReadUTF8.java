package JavaExercise.FileDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadUTF8 {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\abc.txt");

        //byte[] arr = new byte[fileInputStream.available()];
        byte[] arr = new byte[3];
        int x;
        while ((x = fileInputStream.read(arr)) != -1) {
            System.out.println(x);
            System.out.println(new String(arr, 0, x));
        }

        fileInputStream.close();
    }
}
