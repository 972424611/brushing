package com.aekc.noi;

import java.util.Scanner;

public class Noi666 {

    private static int m;

    private static int n;

    private static int sum = 0;

    public static void dfs(int k, int a, int b) {
        if(a == n) {
            sum++;
            return;
        }
        for(int i = k; i <= m; i++) {
            if(i > b - i) {
                break;
            }
            dfs(i, a + 1, b - i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- != 0) {
            m = scanner.nextInt();
            n = scanner.nextInt();
            dfs(0, 1, m);
            System.out.println(sum);
            sum = 0;
        }
    }
}
