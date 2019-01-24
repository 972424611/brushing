package com.aekc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Twilight
 * @date 19-1-24 下午12:31
 */
public class SubsetsTwo {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> sumList = new ArrayList<>();
        sumList.add(new ArrayList<>());
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int length = sumList.size();
            int index = 0;
            if(i > 0 && nums[i] == nums[i - 1]) {
                index = length - sum;
            }
            sum = 0;
            for (int j = index; j < length; j++) {
                Integer[] number = new Integer[sumList.get(j).size() + 1];
                for (int k = 0; k < number.length - 1; k++) {
                    number[k] = sumList.get(j).get(k);
                }
                number[number.length - 1] = num;
                sumList.add(Arrays.asList(number));
                sum++;
            }
        }
        return sumList;
    }

    public static void main(String[] args) {
        SubsetsTwo subsetsTwo = new SubsetsTwo();
        List<List<Integer>> list = subsetsTwo.subsetsWithDup(new int[] {4, 4, 4, 1, 4});
        for(List l : list) {
            System.out.println(l.toString());
        }
    }
}
