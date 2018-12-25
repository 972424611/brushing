package com.aekc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Twilight
 * @date 18-12-17 下午1:20
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sumList = new ArrayList<>();
        sumList.add(new ArrayList<>());
        for (int num : nums) {
            int length = sumList.size();
            for (int j = 0; j < length; j++) {
                Integer[] number = new Integer[sumList.get(j).size() + 1];
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
        Subsets subsets = new Subsets();
        List<List<Integer>> list = subsets.subsets(new int[] {1, 2, 3, 4, 5, 6});
        for(List l : list) {
            System.out.println(l.toString());
        }
    }
}
