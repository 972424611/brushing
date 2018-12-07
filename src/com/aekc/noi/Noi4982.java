package com.aekc.noi;

import java.util.Scanner;

/**
 * @author Twilight
 * @date 18-12-1 下午8:14
 */
public class Noi4982 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int step1 = 1;
        int step2 = 3;
        for(int i = 1; i < n; i++) {
            int k = step2 * 2 + step1;
            step1 = step2;
            step2 = k;
        }
        System.out.println(step2);
    }
}
