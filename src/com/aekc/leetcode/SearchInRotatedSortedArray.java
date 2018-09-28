package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-9-28 下午5:40
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if(nums.length < 3) {
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        int k = -1;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                k = i;
            }
        }

        int start = 0;
        int end;

        if(k != -1) {
            end = k;
        } else {
            end = nums.length / 2;
        }
        int mid = (start + end) / 2;
        while(start <= end) {
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else if(nums[mid] > target) {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }


        if(k != -1) {
            start = k + 1;
        } else {
            start = nums.length / 2;
        }
        end = nums.length - 1;
        mid = (start + end) / 2;
        while(start <= end) {
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else if(nums[mid] > target) {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        System.out.println(searchInRotatedSortedArray.search(new int[]{7,8,1,2,3,4,5,6}, 2));
    }
}
