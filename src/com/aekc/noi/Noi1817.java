package com.aekc.noi;

import java.util.Scanner;

/**
 * @author Twilight
 * @date 18-11-8 下午4:31
 */
public class Noi1817 {

    private static int[][] wall;

    private static boolean[][] wallFlag;

    private static int sum = 0;

    private static int maxRoom = 0;

    public static void dfs(int x, int y) {
        if(wallFlag[x][y]) {
            return;
        }
        wallFlag[x][y] = true;
        sum++;
        wall[x][y] = 15 - wall[x][y];
        if(wall[x][y] >= 8) {
            wall[x][y] = wall[x][y] - 8;
            dfs(x + 1, y);
        }
        if(wall[x][y] >= 4) {
            wall[x][y] = wall[x][y] - 4;
            dfs(x, y + 1);
        }
        if(wall[x][y] >= 2) {
            wall[x][y] = wall[x][y] - 2;
            dfs(x - 1, y);
        }
        if(wall[x][y] >= 1) {
            wall[x][y] = wall[x][y] - 1;
            dfs(x, y - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        wall = new int[n][m];
        wallFlag = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                wall[i][j] = scanner.nextInt();
            }
        }
        int sumRoom = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!wallFlag[i][j]) {
                    dfs(i, j);
                    if(sum > maxRoom) {
                        maxRoom = sum;
                    }
                    sum = 0;
                    sumRoom++;
                }
            }
        }
        System.out.println(sumRoom);
        System.out.println(maxRoom);
    }
}
