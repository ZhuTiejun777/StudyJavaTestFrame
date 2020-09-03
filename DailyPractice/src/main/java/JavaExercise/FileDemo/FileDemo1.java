package JavaExercise.FileDemo;

import java.io.File;

public class FileDemo1 {

    public static void main(String[] args) {
        // 初始化方法
        File file1 = new File("C:\\Users\\Administrator\\Desktop\\abc");
        File file2 = new File("C:\\Users\\Administrator\\Desktop\\cba");
        // 判断文件是否存在
        System.out.println(file1.exists());
        // 创建文件夹
        System.out.println(file1.mkdir());
        // 文件重命名
        System.out.println(file1.renameTo(file2));
        // 删除功能
        System.out.println(file1.delete());
        System.out.println(file2.delete());
        // 判断是否是文件
        System.out.println(file1.isFile());
        //判断是否是文件夹
        System.out.println(file1.isDirectory());
        //设置文件不可读
        //file1.setReadable(false);
        // 判断文件是否可读
        System.out.println(file1.canRead());
        // 判断是否为隐藏
        System.out.println(file1.isHidden());
        //获取文件的绝对路径
        System.out.println(file1.getAbsolutePath());
        //获取文件的路径
        System.out.println(file1.getPath());
        //获取文件或文件夹的名称
        System.out.println(file1.getName());
        //获取文件的字节长度
        System.out.println(file1.length());
        //获取文件的最后一次修改时间
        System.out.println(file1.lastModified());
        // 获取指定文件下的名称数组
        String[] arr = file1.list();
        // 获取指定路径下的文件对象
        File[] files = file1.listFiles();
    }
}
