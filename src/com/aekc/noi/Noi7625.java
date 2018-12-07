package com.aekc.noi;

import java.util.Scanner;

/**
 * @author Twilight
 * @date 18-12-7 下午5:50
 */
public class Noi7625 {

    private static int[][] map;

    private static int[][] cost;

    private static int h;

    private static int max = 0;

    public static int dp(int i, int j, int layer) {
        if(cost[i][j] != Integer.MAX_VALUE) {
            return cost[i][j];
        }
        if(layer == h) {
            return 0;
        }
        int x= 0;
        int y = 0;
        if(j < layer + 1 && i < h - 1) {
            x = map[i + 1][j + 1] + dp(i + 1, j + 1, layer + 1);
        }
        if(i < h - 1) {
            y = map[i + 1][j] + dp(i + 1, j, layer + 1);
        }
        cost[i][j] = Math.max(x, y);
        max = Math.max(max, cost[i][j]);
        return cost[i][j];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        h = scanner.nextInt();
        map = new int[h][h];
        cost = new int[h][h];
        for(int i = 0; i < h; i++) {
            for(int j = 0; j <= i; j++) {
                map[i][j] = scanner.nextInt();
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        dp(0, 0, 1);
        System.out.println(max + map[0][0]);
    }
}
