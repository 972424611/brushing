package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 19-1-17 下午7:40
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while(p >= 0) {
            if(i >= 0 && j >= 0) {
                if(nums1[i] >= nums2[j]) {
                    nums1[p--] = nums1[i--];
                } else {
                    nums1[p--] = nums2[j--];
                }
            } else if(i >= 0) {
                nums1[p--] = nums1[i--];
            } else {
                nums1[p--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {

    }
}
