package TeaseOutKnowledge.twentyfirst;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流复制数据
 */

public class CopyFileDemo {

    public static void main(String[] args) throws IOException {
        // 封装数据源
        FileInputStream fis = new FileInputStream("a.txt");
        // 封装目的地
        FileOutputStream fos = new FileOutputStream("b.txt");

        int by = 0;
        while ((by = fis.read()) != -1) {
            fos.write(by);
        }

        // 复制数据
        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = fis.read(bys)) != -1) {
            fos.write(bys, 0, len);
        }

        // 释放资源(先关谁都行)
        fos.close();
        fis.close();
    }
}
