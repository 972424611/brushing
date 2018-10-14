package com.aekc.leetcode;

import java.util.Arrays;

/**
 * @author Twilight
 * @date 18-9-28 下午7:31
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int start = -1, end = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                if(start == -1) {
                    start = i;
                    end = i;
                } else {
                    end = i;
                }
            }
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray findFirstAndLastPositionOfElementInSortedArray = new FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.toString(findFirstAndLastPositionOfElementInSortedArray.searchRange(new int[]{5,7,7,8,8,10}, 8)));
    }
}
