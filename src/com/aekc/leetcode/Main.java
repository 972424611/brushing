//package com.aekc.leetcode;
//
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * @author Twilight
// * @date 18-9-30 下午3:53
// */
//public class Main {
//
//    public static int dfs(int alice, int bob, int[][] a) {
//        for(int i = 0; i < 3; i++) {
//            for(int j = 0; j < 3; j++) {
//                if(a[i][j] == 0) {
//                    int[] c = new int[8];
//                    a[i][j] = 1;
//                    c[0] = a[0][0] + a[0][1] + a[0][2];
//                    c[1] = a[1][0] + a[1][1] + a[1][2];
//                    c[2] = a[2][0] + a[2][1] + a[2][2];
//                    c[3] = a[0][0] + a[1][0] + a[2][0];
//                    c[4] = a[0][1] + a[1][1] + a[2][1];
//                    c[5] = a[0][2] + a[1][2] + a[2][2];
//                    c[6] = a[0][0] + a[1][1] + a[2][2];
//                    c[7] = a[0][2] + a[1][1] + a[2][0];
//                    int sum = 0;
//                    for(int k = 0; k < 8; k++) {
//                        if(c[k] == 2) {
//
//                            sum++;
//                        }
//                    }
//                    if(sum >= 2) {
//                        return ;
//                    } else if(sum == 1) {
//
//                    }
//                }
//            }
//        }
//    }
//
//    public static int judge(int alice, int bob, int[] c, int[][] a) {
//        if(alice == 1 && bob == 1) {
//            if(c[0] == 5 || c[1] == 5 || c[2] == 5 || c[3] == 5 || c[4] == 5) {
//                if(a[1][1] == 4) {
//                    return 0;
//                } else {
//                    return 3;
//                }
//            }
//        }
//
//        for(int i = 0; i < 8; i++) {
//            if(c[i] == 2) {
//                return 9 - (alice + bob);
//            } else if(c[i] == 12) {
//                return -(9 - (alice + bob) + 1);
//            }
//        }
//        return 0;
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int q = scanner.nextInt();
//        for(int p = 0; p < q; p++) {
//            int alice = 0;
//            int bob = 0;
//            int[] c = new int[8];
//            int[][] a = new int[3][3];
//            for(int i = 0; i < 3; i++) {
//                for(int j = 0; j < 3; j++) {
//                    int k = scanner.nextInt();
//                    if(k == 2) {
//                        a[i][j] = 4;
//                    } else {
//                        a[i][j] = k;
//                    }
//                    if(a[i][j] == 1) {
//                        ++alice;
//                    } else if(a[i][j] == 4) {
//                        ++bob;
//                    }
//                }
//            }
//            c[0] = a[0][0] + a[0][1] + a[0][2];
//            c[1] = a[1][0] + a[1][1] + a[1][2];
//            c[2] = a[2][0] + a[2][1] + a[2][2];
//            c[3] = a[0][0] + a[1][0] + a[2][0];
//            c[4] = a[0][1] + a[1][1] + a[2][1];
//            c[5] = a[0][2] + a[1][2] + a[2][2];
//            c[6] = a[0][0] + a[1][1] + a[2][2];
//            c[7] = a[0][2] + a[1][1] + a[2][0];
//            System.out.println(dfs(alice, bob, c, a));
//        }
//    }
//
//    /*public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int m = scanner.nextInt();
//        int l = scanner.nextInt();
//        int r = scanner.nextInt();
//        int[] a = new int[m];
//        for(int i = 0; i < m; i++) {
//            a[i] = scanner.nextInt();
//        }
//        BigInteger[] b = new BigInteger[r + 1];
//        b[0] = BigInteger.valueOf(1);
//        for(int i = 1; i < b.length; i++) {
//            b[i] = BigInteger.valueOf(0);
//        }
//
//        for(int i = 1; i <= r; i++) {
//            for(int j = 0; j < m; j++) {
//                if(i - j - 1 < 0) {
//                    break;
//                }
//                b[i] = b[i].add((b[i - j - 1].multiply(BigInteger.valueOf(a[j]))));
//            }
//            if(b[i].compareTo(BigInteger.valueOf(998244353)) > 0) {
//                b[i] = b[i].remainder(BigInteger.valueOf(998244353));
//            }
//        }
//        for(int i = l; i < b.length; i++) {
//            System.out.println(b[i]);
//        }
//    }*/
//}
