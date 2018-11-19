package com.aekc.noi;

import java.util.Scanner;

public class Noi2985 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int[] value = new int[1001];
        value[0] = 1;
        for(int i = 1; i <= n; i++) {
            int b = scanner.nextInt();
            for(int j = t; j >= b; j--) {
                value[j] += value[j - b];
            }
        }
        System.out.println(value[t]);
    }
}
