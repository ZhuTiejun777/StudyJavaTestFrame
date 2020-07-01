package TeaseOutKnowledge.twentieth;

import java.io.File;
import java.io.IOException;

/**
 * 创建功能：
 *      public boolean createNewFile():创建文件 如果存在这样的文件，就不创建了
 *      public boolean mkdir():创建文件夹 如果存在这样的文件夹，就不创建了
 *      public boolean mkdirs():创建文件夹,如果父文件夹不存在，会帮你创建出来
 */

public class FileDemo2 {

    public static void main(String[] args) throws IOException {

        // 需求：我要在g盘目录下创建一个文件夹adu
        File file = new File("g:\\adu");
        System.out.println("mkdir:" + file.mkdir());

        // 需求:我要在g盘目录adu下创建一个文件a.txt
        File file2 = new File("g:\\adu\\a.txt");
        System.out.println("createNewFile:" + file2.createNewFile());
        //创建多级目录
        File file3 = new File("g:\\aaa\\bbb\\ccc\\ddd");
        System.out.println("mkdirs:" + file3.mkdirs());


    }
}
