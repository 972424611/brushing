package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-10-21 下午6:35
 */
public class ClimbingStairs {

    private int[] temp;

    public int deal(int n) {
        if(temp[n - 1] != 0) {
            return temp[n - 1];
        }
        temp[n - 1] = deal(n - 1) + deal(n - 2);
        return temp[n - 1];
    }

    public int climbStairs(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        temp = new int[n];
        temp[0] = 1;
        temp[1] = 2;
        return deal(n);
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(0));
    }
}
