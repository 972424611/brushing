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
        while(p < matrix.length && p < matrix[0].length) {
            for(int i = p; i < matrix[0].length - p; i++) {
                if(list.size() == matrix.length * matrix[0].length) {
                    break;
                }
                list.add(matrix[p][i]);
            }
            for(int i = p + 1; i < matrix.length - p; i++) {
                if(list.size() == matrix.length * matrix[0].length) {
                    break;
                }
                list.add(matrix[i][matrix[0].length - p - 1]);

            }
            for(int i = matrix[0].length - p - 2; i >= p; i--) {
                if(list.size() == matrix.length * matrix[0].length) {
                    break;
                }
                list.add(matrix[matrix.length - p - 1][i]);

            }
            for(int i = matrix.length - p - 2; i >= p + 1; i--) {
                if(list.size() == matrix.length * matrix[0].length) {
                    break;
                }
                list.add(matrix[i][p]);

            }
            p++;
        }
        return list;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> list = spiralMatrix.spiralOrder(new int[][]{ {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        for(Integer i : list) {
            System.out.print(i + " ");
        }

    }
}


