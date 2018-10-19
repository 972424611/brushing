package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-10-19 下午7:18
 */
public class MinimumPathSum {

    int[][] nums;

    int[][] temp;

    //1 2 3
    //4 5 6
    //7 8 9

    public int dp(int i, int j) {
        if(temp[i][j] != 0) {
            return temp[i][j];
        }
        if(i == nums.length - 1 && j == nums[0].length - 1) {
            return 0;
        }
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        if(j < nums[0].length - 1) {
            x = nums[i][j + 1] + dp(i, j + 1);
        }
        if(i < nums.length - 1) {
            y = nums[i + 1][j] + dp(i + 1, j);
        }
        temp[i][j] = x > y ? y : x;
        return temp[i][j];
    }

    public int minPathSum(int[][] grid) {
        nums = grid;
        int m = grid.length;
        int n = grid[0].length;
        if(m == 1 && n == 1) {
            return grid[0][0];
        }
        temp = new int[m][n];
        return dp(0, 0) + nums[0][0];
    }

    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        System.out.println(minimumPathSum.minPathSum(new int[][]{{3, 2, 3}, {4, 5, 6}}));
    }
}
