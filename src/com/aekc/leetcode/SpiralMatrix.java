package com.aekc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Twilight
 * @date 18-10-14 下午5:45
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int p = 0;
        while(true) {
            for(int i = p; i < matrix[p].length - p; i++) {
                list.add(matrix[p][i]);
            }

            for(int i = p; i < )
        }
    }

    public static void main(String[] args) {

    }
}
