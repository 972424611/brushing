package com.aekc.noi;

import java.util.Scanner;

public class Noi8464 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0) {
            int n = scanner.nextInt();
            int[] shares = new int[n + 1];
            int[] record = new int[n + 1];
            int[] backRecord = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                shares[i] = scanner.nextInt();
            }
            for(int i = 1; i <= n; i++) {
                int max = 0;
                for(int j = 1; j <= i; j++) {
                    max = Math.max(shares[i] - shares[j], max);
                }
                record[i] = Math.max(record[i - 1], max);
            }
            for(int i = n; i >= 1; i--) {
                int max = 0;
                for(int j = n; j >= i; j--) {
                    max = Math.max(shares[j] - shares[i], max);
                }
                if(i != n) {
                    backRecord[i] = Math.max(backRecord[i + 1], max);
                } else {
                    backRecord[i] = max;
                }
            }
            int maxSum = 0;
            for(int i = 2; i <= n - 1; i++) {
                maxSum = Math.max(maxSum, record[i] + backRecord[i + 1]);
            }
            System.out.println(maxSum);
        }
    }
}
