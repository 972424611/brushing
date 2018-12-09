package com.aekc.noi;

import java.util.Scanner;

/**
 * https://blog.csdn.net/CABI_ZGX/article/details/52525168?locationNum=8
 * @author Twilight
 * @date 18-12-7 下午6:45
 */
public class Noi7627 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] backpack = new int[n + 1][m + 1];
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= m; j++) {
                    backpack[i][j] = i;
                }
            }
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= i; j++) {
                    for(int k = 2; k <= m; k++) {
                        backpack[i][k] = Math.min(backpack[i][k], Math.max(backpack[j - 1][k - 1], backpack[i - j][k]) + 1);
                    }
                }
            }
            System.out.println(backpack[n][m]);
        }

    }
}
