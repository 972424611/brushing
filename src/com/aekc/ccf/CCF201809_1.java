package com.aekc.ccf;

import java.util.Scanner;

/**
 * @author Twilight
 * @date 18-12-9 下午7:05
 */
public class CCF201809_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] today = new int[n];
        int[] tomorrow = new int[n];
        for(int i = 0; i < n; i++) {
            today[i] = scanner.nextInt();
        }
        if(n == 1) {
            System.out.println(today[0]);
        }
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                tomorrow[i] = (today[i] + today[i + 1]) / 2;
                continue;
            }
            if(i == n - 1) {
                tomorrow[i] = (today[i] + today[i - 1]) / 2;
                continue;
            }
            tomorrow[i] = (today[i - 1] + today[i] + today[i + 1]) / 3;
        }
        for(int i = 0; i < n; i++) {
            System.out.print(tomorrow[i] + " ");
        }
    }
}
