package com.aekc.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Twilight
 * @date 18-9-30 下午5:02
 */
public class ValidSudKu {

    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, String> row = new HashMap<>();
        HashMap<Integer, String> col = new HashMap<>();
        HashMap<Integer, String> box = new HashMap<>();

        int[][] p = new int[3][3];
        int q = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                p[i][j] = q++;
            }
        }

        for(int i = 0; i < board.length; i++) {
            row.put(i, "");
            for(int j = 0; j < board[i].length; j++) {
                String k = String.valueOf(board[i][j]);
                col.putIfAbsent(j, "");
                if(!".".equals(k)) {
                    int num = p[i / 3][j / 3];
                    box.putIfAbsent(num, "");
                    if(row.get(i).contains(k)
                            || col.get(j).contains(k)
                            || box.get(num).contains(k)) {
                        return false;
                    } else {
                        row.put(i, row.get(i).concat(k));
                        col.put(j, col.get(j).concat(k));
                        box.put(num, box.get(num).concat(k));
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudKu validSudKu = new ValidSudKu();
        char[][] board = new char[][] {
                ["5","3",".",".","7",".",".",".","."],
                ["6",".",".","1","9","5",".",".","."],
                [".","9","8",".",".",".",".","6","."],
                ["8",".",".",".","6",".",".",".","3"],
                ["4",".",".","8",".","3",".",".","1"],
                ["7",".",".",".","2",".",".",".","6"],
                [".","6",".",".",".",".","2","8","."],
                [".",".",".","4","1","9",".",".","5"],
                [".",".",".",".","8",".",".","7","9"]
        }
        validSudKu.isValidSudoku()
    }
}
