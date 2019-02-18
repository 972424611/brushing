package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 2019-02-17 21:59
 */
public class UniqueBinarySearchTrees {

    // 1 1、2 2、3 5

    public int numTrees(int n) {
        int[] nums = new int[n + 1];
        int total = 3;
        nums[1] = 1;
        nums[2] = 2;
        for(int i = 3; i <= n; i++) {
            nums[i] = nums[i - 1] + ;
            total += nums[i];
        }
        return nums[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        System.out.println(uniqueBinarySearchTrees.numTrees(4));
    }
}
