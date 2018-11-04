package com.aekc.noi;

import java.util.Scanner;

public class Noi2722 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[20001];
        int[] b = new int[n];
        for(int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            a[k]++;
            b[i] = k;
        }
        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(a[b[i] + b[j]] > 0) {
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}
