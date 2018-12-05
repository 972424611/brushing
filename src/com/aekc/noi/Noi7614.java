package com.aekc.noi;

import java.util.Scanner;

public class Noi7614 {

    private static int[][] map;

    private static int[][] cost;

    public static int dp(int i, int j) {
        if(cost[i][j] != 0) {
            return cost[i][j];
        }
        if(i == map.length - 1 && j == map[0].length - 1) {
            return 0;
        }
        int x= Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        if(j < map[0].length - 1) {
            x = map[i][j + 1] + dp(i, j + 1);
        }
        if(i < map.length - 1) {
            y = map[i + 1][j] + dp(i + 1, j);
        }
        cost[i][j] = Math.min(x, y);
        return cost[i][j];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        map = new int[n][n];
        cost = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        if(n == 1) {
            System.out.println(map[0][0]);
        } else {
            System.out.println(dp(0, 0) + map[0][0]);
        }
    }
}
