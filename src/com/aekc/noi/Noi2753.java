package com.aekc.noi;

import java.util.Scanner;

public class Noi2753 {

    private static char[][] map;

    private static int[][] minStepMap;

    private static int step = 0;

    private static int c;

    private static int r;

    public static void dfs(int i, int j) {
        int step = minStepMap[i][j];
        step++;
        if(i > 0 && map[i - 1][j] != '#' && minStepMap[i - 1][j] > step) {
            minStepMap[i - 1][j] = step;
            dfs(i - 1, j);
        }
        if(j > 0 && map[i][j - 1] != '#' && minStepMap[i][j - 1] > step) {
            minStepMap[i][j - 1] = step;
            dfs(i, j - 1);
        }
        if(i < r - 1 && map[i + 1][j] != '#' && minStepMap[i + 1][j] > step) {
            minStepMap[i + 1][j] = step;
            dfs(i + 1, j);
        }
        if(j < c - 1 && map[i][j + 1] != '#' && minStepMap[i][j + 1] > step) {
            minStepMap[i][j + 1] = step;
            dfs(i, j + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        r = scanner.nextInt();
        c = scanner.nextInt();
        map = new char[r][c];
        minStepMap = new int[r][c];
        for(int i = 0; i < r; i++) {
            String temp = scanner.next();
            for(int j = 0; j < c; j++) {
                map[i][j] = temp.charAt(j);
                minStepMap[i][j] = Integer.MAX_VALUE;
            }
        }
        minStepMap[0][0] = 0;
        dfs(0, 0);
        System.out.println(1 + minStepMap[r - 1][c - 1]);
    }
}
