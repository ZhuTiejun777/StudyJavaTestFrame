package TeaseOutKnowledge.twentyfirst;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流写入数据
 *
 * FileOutputStream的构造方法
 *      FileOutputStream(File file)
 *      FileOutputStream(String name)
 * close()
 *      让流对象变成垃圾，这样就可以被垃圾回收器回收了
 *      通知系统去释放跟该文件相关的资源
 * 字节输出流操作步骤：
 *      A：创建字节输出流对象
 *      B：写数据
 *      C：释放资源
 * 字节流写数据
 *      public void write(int b) ：写一个字节
 *      public void write(byte[] b)：写一个字节数组
 *      public void write(byte[] b,int off,int len)：写一个字节数组的一部分
 */

public class FileOutputStreamDemo {

    public static void main(String[] args) throws IOException {
        // 创建字节输出流对象（FileOutputStream的这两种构造方法效果是一样的用那个都可以）

        // FileOutputStream(File file)
        // File file = new File("fos.txt");
        // FileOutputStream fos = new FileOutputStream(file);

        // FileOutputStream(String name)
        FileOutputStream fos = new FileOutputStream("fos.txt");


        //写数据
        fos.write("helloworld".getBytes());
        fos.write("java".getBytes());

        // 调用write()方法
        fos.write(97); //输出结果是97 -- 底层二进制数据 -- 通过记事本打开 -- 找97对应的字符值 -- a

        //public void write(byte[] b):写一个字节数组
        byte[] bys={97,98,99,100,101};
        fos.write(bys);//输出结果是abcde

        //public void write(byte[] b,int off,int len):写一个字节数组的一部分
        fos.write(bys,1,3);//输出结果是bcd

        //释放资源
        //关闭此文件输出流并释放与此流有关的所有系统资源。
        fos.close();

    }
}
