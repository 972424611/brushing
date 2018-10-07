package com.aekc.leetcode;

import java.util.*;

/**
 * @author Twilight
 * @date 18-10-7 上午9:12
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for(int j = i + 1; j <= nums.length - 3; j++) {
                int l = j + 1;
                int k = nums.length - 1;
                if(j - 1 != i && nums[j] == nums[j - 1]) {
                    continue;
                }
                while(l < k) {
                    if(nums[i] + nums[j] + nums[l] + nums[k] == target) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[l], nums[k]));
                        while(l < k && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while(l < k && nums[k] == nums[k - 1]) {
                            k--;
                        }
                        l++;
                        k--;
                    } else if(nums[i] + nums[j] + nums[l] + nums[k] < target) {
                        l++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        List<List<Integer>> list = fourSum.fourSum(new int[] {0,4,-5,2,-2,4,2,-1,4}, 12);
        list.forEach(System.out::println);
    }

}
