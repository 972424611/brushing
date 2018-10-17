package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-10-17 下午7:12
 */
public class SpiralMatrixTwo {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int k = 0, p = 0;
        while(p < matrix.length && p < matrix[0].length) {
            for(int i = p; i < matrix[0].length - p; i++) {
                if(k == matrix.length * matrix[0].length) {
                    break;
                }
                matrix[p][i] = k++ + 1;
            }
            for(int i = p + 1; i < matrix.length - p; i++) {
                if(k == matrix.length * matrix[0].length) {
                    break;
                }
                matrix[i][matrix[0].length - p - 1] = k++ + 1;

            }
            for(int i = matrix[0].length - p - 2; i >= p; i--) {
                if(k == matrix.length * matrix[0].length) {
                    break;
                }
                matrix[matrix.length - p - 1][i] = k++ + 1;

            }
            for(int i = matrix.length - p - 2; i >= p + 1; i--) {
                if(k == matrix.length * matrix[0].length) {
                    break;
                }
                matrix[i][p] = k++ + 1;

            }
            p++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrixTwo spiralMatrixTwo = new SpiralMatrixTwo();
        int[][] matrix = spiralMatrixTwo.generateMatrix(3);
        for(int[] num : matrix) {
            for(int k : num) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}
