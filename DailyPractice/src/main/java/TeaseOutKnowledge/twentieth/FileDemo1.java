package TeaseOutKnowledge.twentieth;

import java.io.File;
import java.io.IOException;

/**
 * File类的概述
 *      文件和目录(文件夹)路径名的抽象表示形式
 * 构造方法
 *      File(String pathname)：根据一个路径得到File对象
 *      File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
 *      File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
 */

public class FileDemo1 {

    public static void main(String[] args) throws IOException {

        FileDemo1 fileDemo = new FileDemo1();
        File file = fileDemo.path();

        File directory = new File("");//参数为空
        String courseFile = directory.getCanonicalPath() ;
        System.out.println(courseFile);

        System.out.println(System.getProperty("user.dir"));

        //System.out.println( System.getProperty("java.class.path"));

        // File(String pathname)：根据一个路径得到File对象
        // 把e:\\adu\\a.txt封装成一个File对象
        //File file1 = new File("E:\\adu\\a.txt");

        // File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
        //File file2 = new File("E:\\adu", "a.txt");

        // File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
        //File file3 = new File("e:\\adu");
        //File file4 = new File(file3, "a.txt");

        // 以上三种方式其实效果一样
    }

    public File path() {
        File file = new File(this.getClass().getResource("/").getPath());
        System.out.println(file);
        return file;
    }
}
