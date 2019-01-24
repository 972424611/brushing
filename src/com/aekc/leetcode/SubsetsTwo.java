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
        List<List<Integer>> sumList = new ArrayList<>();
        sumList.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int length = sumList.size();
            int index = length - 1;
            for (int j = 0; j < length; j++) {
                Integer[] number = new Integer[sumList.get(j).size() + 1];
                if(sumList.get(j).get(sumList.get(j).size() - 1) == num) {

                }
                for (int k = 0; k < number.length - 1; k++) {
                    number[k] = sumList.get(j).get(k);
                }
                number[number.length - 1] = num;
                sumList.add(Arrays.asList(number));
            }
        }
        return sumList;
    }

    public static void main(String[] args) {
        SubsetsTwo subsetsTwo = new SubsetsTwo();
        List<List<Integer>> list = subsetsTwo.subsetsWithDup(new int[] {1, 2, 2, 2, 5, 6, 6});
        for(List l : list) {
            System.out.println(l.toString());
        }
    }
}
