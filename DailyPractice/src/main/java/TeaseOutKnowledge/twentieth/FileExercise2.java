package TeaseOutKnowledge.twentieth;

import java.io.File;
import java.io.FilenameFilter;

public class FileExercise2 {

    public static void main(String[] args) {
        // 封装e判断目录
        File file = new File("e:\\");

        // 获取该目录下所有文件或者文件夹的String数组
        // public String[] list(FilenameFilter filter)
        String[] strArray = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                //如果是文件，输出以.jpg结尾的文件，这两个条件要同时满足
                return new File(dir, name).isFile() && name.endsWith(".jpg");
            }
        });
        // 遍历
        for (String s : strArray) {
            System.out.println(s);
        }
    }
}
