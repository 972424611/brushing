package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-10-1 下午5:03
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) {
            return 1;
        }
        int[] temp = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0 && nums[i] <= nums.length) {
                temp[nums[i]] = 1;
            }
        }
        for(int i = 1; i < temp.length; i++) {
            if(temp[i] != 1) {
                return i;
            }
        }
        return temp.length;
    }

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();

        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{1, 2}));
    }
}
