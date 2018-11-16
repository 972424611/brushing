//package com.aekc.noi;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Noi2000 {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int m = scanner.nextInt();
//        int n = scanner.nextInt();
//        int[] num1 = new int[m + 1];
//        int[] num2 = new int[m + 1];
//        int[][] dp = new int[m + 1][n + 1];
//        for(int i = 1; i <= m; i++) {
//            num1[i] = scanner.nextInt();
//        }
//        for(int i = 1; i <= n; i++) {
//            num2[i] = scanner.nextInt();
//        }
//        List<Integer> list = new ArrayList<>();
//        for(int i = 1; i <= m; i++) {
//            for(int j = 1; j <= n; j++) {
//                if(num1[i] == num2[j]) {
//                    list.add(num1[i]);
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//        for()
//    }
//}
