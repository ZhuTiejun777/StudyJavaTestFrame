package JavaExercise.RecursionFileDemo;

import java.io.File;
import java.util.Scanner;

public class RecursionFileDemo3 {

    /**
     *
     * @param args
     * 分析：
     * 1.定义一个求和变量，表示文件夹大小
     * 2.获取到该文件夹路径下的所有的文件和文件夹，存储在File数组中
     * 3.遍历数组，对每一个文件或者文件夹做判断
     * 4.判断是文件就计算大小并累加
     * 5.如果是文件夹，就递归调用
     */

    public static void main(String[] args) {
        File dir = getDir();
        System.out.println(getFileLength(dir));
    }

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
     * 获取文件夹下文件大小
     */

    public static long getFileLength(File dir) {
        //1定义一个求和变量
        long length = 0;
        //2.获取文件夹下所有文件夹和文件
        File[] files = dir.listFiles();
        //3.遍历数组
        for (File file : files) {
            //4.判断是文件就计算大小
            if(file.isFile()) {
                length = length + file.length();
            }else {
                //5.如果是文件夹，就递归调用
                length = length + getFileLength(file);
            }
        }
        return length;
    }

}
