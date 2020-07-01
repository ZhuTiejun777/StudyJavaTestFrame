package TeaseOutKnowledge.twentieth;

import java.io.File;

/**
 * 删除功能
 *      public boolean delete()
 * 重命名功能
 *      public boolean renameTo(File dest)
 */

public class FileDemo3 {

    public static void main(String[] args) {

        // 创建文件
        // File file = new File("e:\\a.txt");
        // System.out.println("createNewFile:" + file.createNewFile());

        // 删除功能：我要删除a.txt这个文件
        File file3 = new File("e:\\a.txt");
        System.out.println("delete:" + file3.delete());

        // 我们创建几个文件夹
        File file2 = new File("aaa\\bbb\\ccc");
        System.out.println("mkdirs:" + file2.mkdirs());

        // 删除功能：我要删除ccc这个文件夹
        File file4 = new File("aaa\\bbb\\ccc");
        System.out.println("delete:" + file4.delete());

        // 删除功能：我要删除aaa文件夹
        // File file5 = new File("aaa");
        // System.out.println("delete:" + file5.delete());//我们发现删不掉

        //只能用以下这种方法删
        File file6 = new File("aaa\\bbb");
        File file7 = new File("aaa");
        System.out.println("delete:" + file6.delete());
        System.out.println("delete:" + file7.delete());

        //如果路径名相同，就是改名。
        //如果路径名不同，就是改名并剪切。
        //路径以盘符开始：绝对路径 c:\a.txt
        //路径不以盘符开始：相对路径 a.txt
        // 创建一个文件对象
        File file8 = new File("g:\\1.jpg");
        // 需求：我要修改这个文件的名称为"2.jpg"
        File File9 = new File("g:\\2.jpg");
        System.out.println("renameTo:" + file8.renameTo(File9));

        File file10 = new File("g:\\2.jpg");
        File File11 = new File("e:\\adu.jpg");
        System.out.println("renameTo:" + file10.renameTo(File11));

    }
}
