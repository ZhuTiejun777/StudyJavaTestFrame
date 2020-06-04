package com.study;

import java.util.Scanner;

public class StudyScanner {

    public static void main(String[] args) {
        Scanner input1 = new Scanner(System.in);
        System.out.println("请输入数字:");
        int user_input_int = input1.nextInt();
        System.out.println(user_input_int);

        Scanner input2 = new Scanner(System.in);
        System.out.println("请输入小数:");
        double user_input_double = input2.nextDouble();
        System.out.println(user_input_double);

    }

}
