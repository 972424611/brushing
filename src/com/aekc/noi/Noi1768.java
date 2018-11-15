package com.aekc.noi;

import java.util.Scanner;

public class Noi1768 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                nums[i][j] = scanner.nextInt();
                nums[i][j] += nums[i - 1][j];
            }
        }
        int max = nums[1][1];
        for(int i = 1; i <= n; i++) {
            for(int j = i; j <= n; j++) {
                int sum = 0;
                for(int k = 1; k <= n; k++) {
                    int temp = nums[j][k] - nums[i - 1][k];
                    if(sum >= 0) {
                        sum += temp;
                    } else {
                        sum = temp;
                    }
                    if(sum > max) {
                        max = sum;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
