package com.aekc.noi;

import java.util.Scanner;

public class Noi1759 {

    public static int binary(int[] dp, int k, int pos) {
        int start = 0;
        int end = pos;
        int medium = 0;
        while(start <= end) {
            medium = (start + end) / 2;
            if(dp[medium] == k) {
                return medium;
            } else if(dp[medium] < k) {
                start = medium + 1;
            } else {
                end = medium - 1;
            }
        }
        return medium;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n == 0) {
            System.out.println(0);
            return;
        }
        int[] nums = new int[n];
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int pos = 0;
        dp[0] = nums[0];
        for(int i = 1; i < n; i++) {
           if(nums[i] > dp[pos]) {
               dp[++pos] = nums[i];
           } else {
               dp[binary(dp, nums[i], pos)] = nums[i];
           }
        }
        System.out.println(pos + 1);
    }
}
