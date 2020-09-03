package JavaExercise.RecursionFileDemo;

import java.io.File;
import java.util.Scanner;



public class RecursionFileDemo5 {

    public static void main(String[] args) {
        File dir = getDir();
        deleteFolder(dir);
    }

    /**
     * 获取文件夹路径
     * @return
     * 删除一个文件夹下所有文件和子文件夹
     * 分析：
     * 1）获取该文件夹下的所有文件和文件夹
     * 2）遍历文件数组
     * 3）判断是文件就直接删除
     * 4）判断是文件夹，就递归调用
     * 5）循环结束之后，把空文件夹全部删除
     */
    public static File getDir () {
        //创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个文件路径。");

        while(true) {
            String line = sc.nextLine();          //键盘录入文件夹路径存储
            File dir = new File(line);            //封装file对象

            //判断
            if( !dir.exists()) {
                System.out.println("你输入的文件夹路径不存在，请重新输入。");
            }else if(dir.isFile()) {
                System.out.println("你输入的是一个文件的路径，请换成文件夹路径");
            }else {
                return dir;
            }
        }
    }

    /**
     * 删除该文件夹
     *
     */
    public static void deleteFolder(File dir) {
        //1.获取该路径下所有文件夹和文件夹
        File[] subFiles = dir.listFiles();
        //2.遍历数组
        for (File subfile : subFiles) {
            //3.判断是文件就删除
            if( subfile.isFile()) {
                subfile.delete();
            }else {
                //4.是文件夹就递归调用，删除文件
                deleteFolder(subfile);
            }
        }
        //5.循环结束之后，删除文件夹
        dir.delete();
    }

}

