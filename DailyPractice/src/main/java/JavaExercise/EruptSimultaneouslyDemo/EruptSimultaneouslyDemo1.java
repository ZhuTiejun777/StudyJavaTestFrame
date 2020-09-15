package JavaExercise.EruptSimultaneouslyDemo;

public class EruptSimultaneouslyDemo1 {

    public static void main(String[] args) {

        final PrintDemo printDemo = new PrintDemo();

        new Thread() {
            public void run () {
                while (true) {
                    try {
                        printDemo.printDemo1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            public void run () {
                while (true) {
                    try {
                        printDemo.printDemo2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }
}

