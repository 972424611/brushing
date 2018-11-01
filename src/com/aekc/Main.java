package com.aekc;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static boolean judge(int[] a, int[] b) {
        a[0] = a[1];
        if(a[0] != b[0]) {
            return false;
        }
        for(int i = 1; i < a.length; i++) {
            if(i == a.length - 1) {
                a[i] = a[i - 1];
            } else {
                a[i] = (a[i - 1] + a[i + 1]) / 2;
            }
            if(a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] b = new int[n];
        for(int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        int[] a = new int[n];
        int k = 0;
        while(!judge(a, b)) {
            a[k++]++;
            if(k == n) {
                k = 0;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
