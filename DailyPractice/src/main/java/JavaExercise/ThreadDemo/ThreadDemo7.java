package JavaExercise.ThreadDemo;

public class ThreadDemo7 {

    public static void main(String[] args) {

        final PrintDemo printDemo = new PrintDemo();

        new Thread() {
            public void run(){
                while(true) {
                    printDemo.print1();
                }
            }
        }.start();

        new Thread() {
            public void run(){
                while(true) {
                    printDemo.print2();
                }
            }
        }.start();
    }
}

