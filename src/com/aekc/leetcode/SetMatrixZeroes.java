package com.aekc.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Twilight
 * @date 18-10-24 下午7:49
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        boolean[][] judge = new boolean[n][m];
        for(int i = 0, x = n - 1; i < n && x >= 0; i++, x--) {
            for(int j = 0, y = m - 1; j < m && y >= 0; j++, y--) {
                if(rowSet.contains(i) || colSet.contains(j)) {
                    if(matrix[i][j] != 0) {
                        matrix[i][j] = 0;
                        judge[i][j] = true;
                    }
                }
                if(rowSet.contains(x) || colSet.contains(y)) {
                    if(matrix[x][y] != 0) {
                        matrix[x][y] = 0;
                        judge[x][y] = true;
                    }
                }
                if(matrix[i][j] == 0 && !judge[i][j]) {
                    rowSet.add(i);
                    colSet.add(j);
                }
                if(matrix[x][y] == 0 && !judge[x][y]) {
                    rowSet.add(x);
                    colSet.add(y);
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        setMatrixZeroes.setZeroes(new int[][] {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
        setMatrixZeroes.setZeroes(new int[][] {{1, 1, 2}, {3, 0, 5}, {1, 3, 1}});
    }
}
