package com.study;

public class StudyFor {

    public static void main(String[] args) {
        int [] myarr = {1, 2, 3, 4};
        for (int i = 0; i < myarr.length; i ++) {
            System.out.println(myarr[i]);
        }

        int sum = 0;
        for (int num = 1; num <= 100; num ++) {
            sum += num;
        }
        System.out.println(sum);
    }
}
