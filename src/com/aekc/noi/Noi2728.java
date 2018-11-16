package com.aekc.noi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Noi2728 {

    private static int[][] nums;

    private static int[][] maxPeanut;

    private static int r;

    private static int c;

    public static int dp(int x, int y) {
        if(maxPeanut[x][y] != 0) {
            return maxPeanut[x][y];
        }
        if(x == r - 1&& y == c - 1) {
            return nums[x][y];
        }
        if(x == r - 1) {
            return nums[x][y] + dp(x, y + 1);
        }
        if(y == c - 1) {
            return nums[x][y] + dp(x + 1, y);
        }
        maxPeanut[x][y] = nums[x][y] + Math.max(dp(x + 1, y), dp(x, y + 1));
        return maxPeanut[x][y];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        List<Integer> list = new ArrayList<>(t);
        while(t-- > 0) {
            r = scanner.nextInt();
            c = scanner.nextInt();
            nums = new int[r][c];
            maxPeanut = new int[r][c];
            for(int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++) {
                    nums[i][j] = scanner.nextInt();
                }
            }
            list.add(dp(0, 0));
        }
        list.forEach(System.out::println);
    }
}
