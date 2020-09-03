package JavaExercise.FileDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo1 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\abc.txt");
        int x = fileInputStream.read();
        System.out.println(x);
        int y = fileInputStream.read();
        System.out.println(y);
        int z = fileInputStream.read();
        System.out.println(z);
        // 输出-1表示文件结束
        int a = fileInputStream.read();
        System.out.println(a);
        fileInputStream.close();
    }
}
