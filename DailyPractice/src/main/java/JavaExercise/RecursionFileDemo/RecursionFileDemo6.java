package JavaExercise.RecursionFileDemo;

import java.io.File;
import java.util.Scanner;

public class RecursionFileDemo6 {

    /**
     * 题目：把文件夹下文件和文件夹按层级打印（linux中树形打印）
     * 分析
     * @param args
     * 1.获取所有文件夹和文件，存储在File数组中
     * 2.遍历数组
     * 3.无论是文件还是文件夹都需要打印
     * 4.如果是文件夹，递归调用
     */

    public static void main(String[] args) {
        File dir = getDir();
        printDir(dir,0);
    }

    public static void printDir(File dir,int level) {
        //1.获取所有文件夹和文件，存储在File数组中
        File[] subFiles = dir.listFiles();
        //2.遍历数组
        for (File subfile : subFiles) {
            //3.无论是文件还是文件夹都需要打印
            for (int i = 0; i <= level; i++) {
                System.out.print("\t");
            }
            System.out.println(subfile);
            //4.如果是文件夹，递归调用
            if(subfile.isDirectory()) {
                printDir(subfile,level + 1);
            }
        }

    }


    /**
     * 获取文件夹路径
     * @return
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

}
