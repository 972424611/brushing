package com.aekc.noi;

import java.util.Scanner;

public class Noi2718 {

    public static int[][] step;

    private static int m;

    private static int n;

    public static int dp(int x, int y) {
        if(step[x][y] != 0) {
            return step[x][y];
        }
        if(x == m && y == n) {
            return 1;
        }
        if(x == m) {
            return dp(x, y + 1);
        }
        if(y == n) {
            return dp(x + 1, y);
        }
        step[x][y] = dp(x + 1, y) + dp(x, y + 1);
        return step[x][y];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        step = new int[m + 1][n + 1];
        int k = dp(1, 1);
        System.out.println(k);
    }
}
