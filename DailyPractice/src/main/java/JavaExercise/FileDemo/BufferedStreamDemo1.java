package JavaExercise.FileDemo;

import java.io.*;

public class BufferedStreamDemo1 {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\git.png");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\copy.png");
        // 创建缓冲流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        int x;
        while ((x = bufferedInputStream.read()) != -1) {
            bufferedOutputStream.write(x);
        }

        bufferedInputStream.close();
        bufferedOutputStream.close();

    }
}
