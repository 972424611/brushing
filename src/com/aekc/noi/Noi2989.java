package com.aekc.noi;

import java.util.*;

public class Noi2989 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] value = new int[n + 1];
        int[][] backpack = new int[n + 1][k + 1];
        for(int i = 1; i <= n; i++) {
            value[i] = scanner.nextInt();
        }
         
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < k; j++) {
                backpack[i][j] = backpack[i - 1][j];
                backpack[i][j] = Math.max(backpack[i][j], backpack[i - 1][(j - value[i] % k + k) % k] + value[i]);
            }
        }
        System.out.println(backpack[n][0]);
    }
}
