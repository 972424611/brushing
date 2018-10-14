package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-10-14 下午4:11
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if(nums.length < 2) {
            return nums[0];
        }

        int max = Integer.MIN_VALUE, k = 0;
        int i = 0, p = 0;
        while(i < nums.length) {
            if(nums[i] < 0) {
                p = p + nums[i];
                if(nums[i] > max) {
                    max = nums[i];
                }
                i++;
                continue;
            }
            if(nums[i] <= k + nums[i] + p) {
                k = k + nums[i] + p;
                p = 0;
            } else {
                k = nums[i];
                p = 0;
            }
            if(k > max) {
                max = k;
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(new int[] {-2,-1}));
    }
}
