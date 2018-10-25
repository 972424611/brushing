package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-10-25 下午3:41
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int[] a = new int[3];
        for(int i = 0; i < nums.length; i++) {
            a[nums[i]]++;
        }
        int k = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < a[i]; j++) {
                nums[k++] = nums[j];
            }
        }
    }

    public static void main(String[] args) {

    }
}
