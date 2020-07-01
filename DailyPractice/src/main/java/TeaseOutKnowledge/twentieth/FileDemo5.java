package TeaseOutKnowledge.twentieth;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取功能（基本获取功能）
 *      public String getAbsolutePath()：获取绝对路径
 *      public String getPath():获取相对路径
 *      public String getName():获取名称
 *      public long length():获取长度。字节数
 *      public long lastModified():获取最后一次的修改时间，毫秒值
 * 获取功能（高级获取功能）
 *      public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
 *      public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组
 */

public class FileDemo5 {

    public static void main(String[] args) {

        // 创建文件对象
        File file = new File("g:\\adu\\a.txt");

        System.out.println("getAbsolutePath:" + file.getAbsolutePath());
        System.out.println("getPath:" + file.getPath());
        System.out.println("getName:" + file.getName());
        System.out.println("length:" + file.length());
        System.out.println("lastModified:" + file.lastModified());

        //1472893011393
        Date d = new Date(1472893011393L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = sdf.format(d);
        System.out.println(s);

        // 指定一个目录
        File file1 = new File("g:\\");

        // public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
        String[] strArray = file1.list();
        for (String str : strArray) {
            System.out.println(str);
        }
        System.out.println("------------");

        // public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组
        File[] fileArray = file1.listFiles();
        for (File f : fileArray) {
            System.out.println(f.getName());
        }
    }
}
