package JavaExercise.FileDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo1 {

    public static void main(String[] args) throws IOException {
        //字节输出流，如果没有该文件就会自动创建有一个，有就不会
        FileOutputStream fileOutputStream1 = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\abc.txt");
        // 清除原有内容,在写入d
        fileOutputStream1.write(100);
        fileOutputStream1.close();

        // 初始化加入true参数,则不会清空原文件
        FileOutputStream fileOutputStream2 = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\abc.txt", true);
        fileOutputStream2.write(97);
        fileOutputStream2.write(97);
        fileOutputStream2.write(97);
        fileOutputStream2.close();
    }
}
