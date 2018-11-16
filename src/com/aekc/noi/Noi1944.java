package com.aekc.noi;

import java.util.Scanner;

public class Noi1944 {

    private static int[] sum;

    public static int dp(int n) {
        if(sum[n] != 0) {
            return sum[n];
        }
        sum[n] = dp(n - 1) + dp(n - 2);
        return sum[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        sum = new int[n + 1];
        sum[0] = 1;
        sum[1] = 1;
        System.out.println(dp(n));

    }
}
