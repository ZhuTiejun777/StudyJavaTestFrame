package JavaExercise.ThreadDemo;

public class ThreadDemo8 {

    public static void main(String[] args) {
        new Ticket().start();
        new Ticket().start();
        new Ticket().start();
        new Ticket().start();
    }
}
