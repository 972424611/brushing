package com.aekc.noi;

import java.util.Scanner;

/**
 * @author Twilight
 * @date 18-11-8 下午5:24
 */
public class Noi1818 {

    private static int sum = 0;

    private static boolean[][] flag;

    private static char[][] tile;

    public static void dfs(int x, int y) {
        sum++;
        flag[x][y] = true;
        if(!flag[x + 1][y]) {
            dfs(x + 1, y);
        }
        if(!flag[x - 1][y]) {
            dfs(x - 1, y);
        }
        if(!flag[x][y + 1]) {
            dfs(x, y + 1);
        }
        if(!flag[x][y - 1]) {
            dfs(x, y - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            if(n == 0 && m == 0) {
                break;
            }
            tile = new char[n + 2][m + 2];
            flag = new boolean[n + 2][m + 2];
            int x = 0, y = 0;
            for(int i = 0; i < n; i++) {
                String temp = scanner.next();
                for(int j = 0; j < temp.length(); j++) {
                    tile[i + 1][j + 1] = temp.charAt(j);
                }
            }
            for(int i = 0; i < n + 2; i++) {
                for(int j = 0; j < m + 2; j++) {
                    if(i == 0 || j == 0 || i == n + 1 || j == m + 1 || tile[i][j] == '#') {
                        flag[i][j] = true;
                    } else if(tile[i][j] == '@') {
                        x = i;
                        y = j;
                    }
                }
            }
            dfs(x, y);
            System.out.println(sum);
            sum = 0;
        }
    }
}
