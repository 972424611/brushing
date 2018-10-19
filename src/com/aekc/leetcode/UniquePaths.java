package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-10-18 下午8:28
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) {
            return 1;
        }
        int[][] nums = new int[m][n];
        int sum = 0;
        for(int i = m - 1; i > 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == m - 1 || j == n - 1) {
                    nums[i][j] = 1;
                } else {
                    nums[i][j] = nums[i + 1][j] + nums[i][j + 1];
                }
                if(i == 1) {
                    sum = sum + nums[i][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(7, 7));
    }
}
