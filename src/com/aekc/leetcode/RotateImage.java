package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-10-5 下午6:46
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        int[][] nums = new int[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                nums[j][i] = matrix[matrix.length - i - 1][j];
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                matrix[i][j] = nums[i][j];
            }
        }
    }

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
