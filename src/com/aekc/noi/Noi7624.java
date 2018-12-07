package com.aekc.noi;

import java.util.Scanner;

/**
 * @author Twilight
 * @date 18-12-7 下午4:38
 */
public class Noi7624 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] map = new int[m + 1][m + 1];
        int[][] step = new int[m + 1][m + 1];
        for(int i = 2; i <= m; i++) {
            int distance = scanner.nextInt();
            for(int j = 1; j < i; j++) {
                map[j][i] = distance + map[j][i - 1];
                map[i][j] = map[j][i];
            }
        }
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= m; j++) {
                step[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 1; i <= m; i++) {
            step[i][1] = map[1][i];
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= Math.min(i, n); j++) {
                for(int k = 1; k < i; k++) {
                    if(j != i) {
                        step[i][j] = Math.min(step[i][j], step[k][j - 1] + map[k + 1][i]);
                    }
                }
            }
        }
        System.out.println(step[m][n]);
    }
}
