package com.aekc.noi;

import java.util.Scanner;

public class Noi1808 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            String[] strs = temp.split("\\s+");
            String x = strs[0];
            String y = strs[1];
            // dp[i][j]表示s1的前i个字符和s2的前j个字符的最大公共子列
            int[][] dp = new int[x.length() + 1][y.length() + 1];
            for(int i = 0; i < x.length(); i++) {
                for(int j = 0; j < y.length(); j++) {
                    if(x.charAt(i) == y.charAt(j)) {
                        dp[i + 1][j + 1] = dp[i][j] + 1;
                    } else {
                        dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                    }
                }
            }
            System.out.println(dp[x.length()][y.length()]);
        }
    }
}
