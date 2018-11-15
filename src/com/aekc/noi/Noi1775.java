package com.aekc.noi;

import java.util.Scanner;

/**
 * 01 背包
 */
public class Noi1775 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int m = scanner.nextInt();
        int[] weight = new int[m + 1];
        int[] value = new int[m + 1];
        // backpack[i][j] 表示 在面对第 i 件物品，且背包容量为 j 时所能获得的最大价值
        int[][] backpack = new int[m + 1][t + 1];
        for(int i = 1; i <= m; i++) {
            weight[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }
        for(int i = 1; i <= m; i++) {
            for(int j = t; j >= 1; j--) {
                if(j >= weight[i]) {
                    if(backpack[i - 1][j] < backpack[i - 1][j - weight[i]] + value[i]) {
                        backpack[i][j] = backpack[i - 1][j - weight[i]] + value[i];
                    } else {
                        backpack[i][j] = backpack[i - 1][j];
                    }
                } else {
                    backpack[i][j] = backpack[i - 1][j];
                }
            }
        }
        System.out.println(backpack[m][t]);
    }
}
