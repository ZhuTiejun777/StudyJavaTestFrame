package JavaExercise.FileDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CoptDemo2 {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\git.png");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\copy.png");

        //创建一个字节数组，大小和文件字节大小一致,available()获取文件字节大小
        byte[] arr = new byte[fileInputStream.available()];


        // 文件输入流，把读取字节统一放在字节数组中
        fileInputStream.read(arr);
        // 文件输出流，把字节数组中数据写入到文件
        fileOutputStream.write(arr);

        fileInputStream.close();
        fileOutputStream.close();

    }
}
