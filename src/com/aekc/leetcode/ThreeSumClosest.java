package com.aekc.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        if(target < 0) {
            min = min + target;
        }
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while(j < k) {
                if(Math.abs(nums[i] + nums[j] + nums[k] - target) < Math.abs(min - target)) {
                    min = nums[i] + nums[j] + nums[k];
                } else {
                    if(nums[i] + nums[j] + nums[k] < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        System.out.println(threeSumClosest.threeSumClosest(new int[] {0, 2, 1, -3}, 1));
    }
}