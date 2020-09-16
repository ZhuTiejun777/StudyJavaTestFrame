package frame.study.login;

import java.util.Scanner;

public class Login {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("input user:");
        String user = scanner.nextLine();
        System.out.println("input password:");
        String password = scanner.nextLine();

        if (DoLogin.LoginVerify(user, password)) {
            System.out.println("Login Succeed:" + user);
        } else {
            System.out.println("Wrong Password");
        }
    }
}
