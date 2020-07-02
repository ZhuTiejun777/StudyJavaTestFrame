package TeaseOutKnowledge.twentyfirst;

import java.io.*;

/**
 * 字节缓冲输出流
 *      BufferedOutputStream
 * 字节缓冲输入流
 *      BufferedInputStream
 */

public class BufferedOutputStreamDemo {

    public static void main(String[] args) throws IOException {
        // BufferedOutputStream(OutputStream out)
        // 简单的写法
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream("bos.txt"));

        // 写数据
        bos.write("hello".getBytes());

        // 释放资源
        bos.close();

        // BufferedInputStream(InputStream in)
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
                "bos.txt"));

        // 读取数据
        int by = 0;
        while ((by = bis.read()) != -1) {
            System.out.print((char) by);
        }

        // 多行读取数据
        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = bis.read(bys)) != -1) {
            System.out.print(new String(bys, 0, len));
        }

        // 释放资源
        bis.close();

    }
}
