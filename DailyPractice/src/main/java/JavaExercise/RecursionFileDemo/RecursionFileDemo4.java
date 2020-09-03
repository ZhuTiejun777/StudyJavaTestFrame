package JavaExercise.RecursionFileDemo;

import java.io.*;
import java.util.Scanner;

public class RecursionFileDemo4 {

    public static void main(String[] args) throws IOException {
        File src = getDir();
        File dest = getDir();
        copy(src,dest);
    }

    /**
     * 键盘给定两个文件夹路径，递归实现文件拷贝
     * 获取文件夹路径
     * @return
     * 1）在目标文件夹中，创建原文件夹
     * 2）获取原文件夹中所有的文件和文件夹，存储在File数组中
     * 3）遍历数组，判断
     * 4）如果是文件，就利用IO流读写，实现拷贝
     * 5）如果是文件夹，递归调用
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
     * 文件拷贝
     * 1.返回值类型是void
     * 2.参数列表 File src, File dest
     * @throws IOException
     */
    public static void copy(File src, File dest) throws IOException {
        //如果src和dest提供路径一模一样，例如就会在src下不断死循环地拷贝文件，直到你机器死机。
        // 所以，需要写一个if判断，如果src和dest相等（equals），就写一个相关提示，否则就调用copy方法去拷贝
        if (src.equals(dest)) {
            throw new IOException("Unable to copy");
        }
        //1.在目标文件夹中，创建原文件夹,在dest文件中先创建src这个文件夹名称
        File newDir = new File(dest,src.getName());
        newDir.mkdir();
        //2.获取原文件夹中所有的文件和文件夹，存储在File数组中
        File[] subFiles = src.listFiles();
        //3.遍历数组
        for (File subfile : subFiles) {
            //4.如果是文件，就利用IO流读写，实现拷贝
            if(subfile.isFile()) {
                //这里用字节流的原因是，支持拷贝任何类型文件，不可能只有文本文件
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(subfile));
                BufferedOutputStream bos =
                        new BufferedOutputStream(new FileOutputStream(new File(newDir,subfile.getName())));

                int b;
                while ( (b = bis.read()) != -1) {
                    bos.write(b);
                }
                bis.close();
                bos.close();
            }else {
                copy(subfile, newDir);  //拷贝文件夹
            }
        }
    }
}
