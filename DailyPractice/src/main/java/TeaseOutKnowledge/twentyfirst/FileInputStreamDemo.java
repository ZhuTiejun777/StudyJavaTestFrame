package TeaseOutKnowledge.twentyfirst;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 字节流读取数据
 *
 * FileInputStream的构造方法
 *      FileInputStream(File file)
 *      FileInputStream(String name)
 * FileInputStream的成员方法
 *      public int read()：一次读取一个字节
 *      public int read(byte[] b)：一次读取一个字节数组
 * 字节输入流操作步骤
 *      A：创建字节输入流对象
 *      B：调用read()方法读取数据，并把数据显示在控制台
 *      C：释放资源
 */

public class FileInputStreamDemo {

    public static void main(String[] args) throws IOException {
        //创建字节输入流对象
        FileInputStream fileInputStream = new FileInputStream("fos.txt");

        // 赋值
        int by = 0;
        // 读取
        while ((by = fileInputStream.read()) != -1) {
            System.out.println((char) by);
        }

        // 数组的长度一般是1024或者1024的整数倍
        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(bys)) != -1) {
            System.out.print(new String(bys, 0, len));
        }

        fileInputStream.close();
    }
}
