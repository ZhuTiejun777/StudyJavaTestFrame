package JavaExercise;

import java.io.IOException;

public class RuntimeDemo {

    public static void main(String[] args) throws Exception {

        // 单例模式
        Runtime runtime = Runtime.getRuntime();

        runtime.exec("shutdown -s -t 3600");

        Thread.sleep(10000);

        runtime.exec("shutdown -a");
    }
}
