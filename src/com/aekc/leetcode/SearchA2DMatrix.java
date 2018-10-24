package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-10-24 下午9:26
 */
public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int start = 0;
        int end = matrix.length - 1;
        int middle = 0;
        while(start <= end) {
            middle = (start + end) / 2;
            if(target == matrix[middle][0]) {
                return true;
            } else if(target < matrix[middle][0]) {
                end = middle - 1;
            } else if(target > matrix[middle][0]) {
                start = middle + 1;
            }
        }
        int k;
        if(middle + 1 < matrix.length && matrix[middle + 1][0] <= target && matrix[middle + 1][matrix[0].length - 1] >= target) {
            k = middle + 1;
        } else if(middle - 1 >= 0 && matrix[middle - 1][0] <= target && matrix[middle - 1][matrix[0].length - 1] >= target) {
            k = middle - 1;
        } else {
            k = middle;
        }
        start = 0;
        end = matrix[0].length - 1;
        while(start <= end) {
            middle = (start + end) / 2;
            if(target == matrix[k][middle]) {
                return true;
            } else if(target < matrix[k][middle]) {
                end = middle - 1;
            } else if(target > matrix[k][middle]) {
                start = middle + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
        System.out.println(searchA2DMatrix.searchMatrix(new int[][]{{1}, {10}}, 1));
    }
}
