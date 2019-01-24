package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 19-1-17 下午4:55
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == '0') {
                    continue;
                }
                int x = 1;
                int y = 1;
                for(int k = i + 1; k < matrix.length; k++) {
                    if(matrix[k][j] == '0') {
                        break;
                    }
                    x++;
                }
                for(int k = j + 1; k < matrix[i].length; k++) {
                    if(matrix[i][k] == '0') {
                        break;
                    }
                    y++;
                }
                max = Math.max(x * y, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        char[][] matrix =
                {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle.maximalRectangle(matrix));
    }
}
