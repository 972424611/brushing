package com.aekc.noi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Noi2727 {

    private static char[][] coordinate;

    private static int[][] minCoordinate;

    private static boolean[][] flag;

    private static final int MAX_VALUE = 1000000;

    private static int n;

    private static int m;

    private static int q;

    private static int p;

    public static int dp(int i, int j) {
        if(minCoordinate[i][j] != 0) {
            return minCoordinate[i][j];
        }
        if(coordinate[i][j] == '#') {
            return MAX_VALUE;
        }
        if(i == q && j == p) {
            return 0;
        }
        flag[i][j] = true;
        int up = MAX_VALUE;
        int down = MAX_VALUE;
        int left = MAX_VALUE;
        int right = MAX_VALUE;
        if(i > 0 && !flag[i - 1][j]) {
            up = 1 + dp(i - 1, j);
        }
        if(i < n - 1 && !flag[i + 1][j]) {
            down = 1 + dp(i + 1, j);
        }
        if(j > 0 && !flag[i][j - 1]) {
            left = 1 + dp(i, j - 1);
        }
        if(j < m - 1 && !flag[i][j + 1]) {
            right = 1 + dp(i, j + 1);
        }
        minCoordinate[i][j] = Math.min(up, down);
        minCoordinate[i][j] = Math.min(minCoordinate[i][j], left);
        minCoordinate[i][j] = Math.min(minCoordinate[i][j], right);
        flag[i][j] = false;
        return minCoordinate[i][j];
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            if(n == 0 && m == 0) {
                break;
            }
            coordinate = new char[n][m];
            minCoordinate = new int[n][m];
            flag = new boolean[n][m];
            int x = 0, y = 0;
            for(int i = 0; i < n; i++) {
                String temp = scanner.next();
                for(int j = 0; j < m; j++) {
                    coordinate[i][j] = temp.charAt(j);
                    if(coordinate[i][j] == '@') {
                        x = i;
                        y = j;
                    } else if(coordinate[i][j] == '*') {
                        q = i;
                        p = j;
                    }
                }
            }
            int value = dp(x, y);
            if(value >= MAX_VALUE) {
                list.add(-1);
            } else {
                list.add(value);
            }
        }
        for(Integer i : list) {
            System.out.println(i);
        }
    }
}
