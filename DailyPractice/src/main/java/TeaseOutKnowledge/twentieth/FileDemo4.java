package TeaseOutKnowledge.twentieth;

import java.io.File;

/**
 * 判断功能
 *      public boolean isDirectory():判断是否是目录
 *      public boolean isFile():判断是否是文件
 *      public boolean exists():判断是否存在
 *      public boolean canRead():判断是否可读
 *      public boolean canWrite():判断是否可写
 *      public boolean isHidden():判断是否隐藏
 */

public class FileDemo4 {

    public static void main(String[] args) {

        // 创建文件对象//我们选择G盘已存在的a.txt
        File file = new File("g:\\a.txt");

        System.out.println("isDirectory:" + file.isDirectory());
        System.out.println("isFile:" + file.isFile());
        System.out.println("exists:" + file.exists());
        System.out.println("canRead:" + file.canRead());
        System.out.println("canWrite:" + file.canWrite());
        System.out.println("isHidden:" + file.isHidden());

    }
}
