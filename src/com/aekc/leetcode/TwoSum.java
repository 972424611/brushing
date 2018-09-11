package com.aekc.leetcode;

import java.util.*;

/**
 * @author Twilight
 * @date 18-9-11 下午4:07
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-3, 4, 3, 90};
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, 0)));
    }


}
