package com.aekc.noi;

import java.util.Scanner;

/**
 * @author Twilight
 * @date 18-12-1 下午6:55
 */
public class Noi4978 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[] weight = new int[k + 1];
        int[] value = new int[k + 1];
        int[][] backpack = new int[n + 1][m + 1];
        for(int i = 1; i <= k; i++) {
            weight[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }

        for(int i = 1; i < k; i++) {
            for(int j = n; j >= 0; j--) {
                for(int x = m; x >= 0; x--) {
                    if(j - weight[i] >= 0 && x - value[i] >= 0) {
                        backpack[j][x] = Math.max(backpack[j][x], backpack[j - weight[i]][x - value[i]] + 1);
                    }
                }
            }
        }
        System.out.print(backpack[n][m] + " ");
        for(int i = 0; i <= m; i++) {
            if(backpack[n][i] == backpack[n][m]) {
                System.out.println(m - i);
                break;
            }
        }

    }
}
