package com.aekc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Twilight
 * @date 18-10-14 上午10:11
 */
public class NQueens {

    List<List<String>> result = new ArrayList<>();

    private static int[][] checkerboard;

    /** N代表皇后个数 */
    private static int N;

    public void judge(int i, int j) {
        if(checkerboard[i][j] != 0) {
            checkerboard[i][j]++;
        } else {
            checkerboard[i][j] = 1;
        }
    }

    /**
     * 把原来该格子所在的皇后标识和攻击范围去除。
     */
    public void toBack(int i, int m) {
        for(int j = 0; j < N; j++) {
            checkerboard[m][j]--;
            checkerboard[j][i]--;
        }
        for(int x = i, y = m; x >=0 && y < N; x--, y++) {
            checkerboard[y][x]--;
        }
        for(int x = i, y = m; x < N && y < N; x++, y++) {
            checkerboard[y][x]--;
        }
        for(int x = i, y = m; x < N && y >= 0; x++, y--) {
            checkerboard[y][x]--;
        }
        for(int x = i, y = m; x >= 0 && y >= 0; x--, y--) {
            checkerboard[y][x]--;
        }
        checkerboard[m][i] = 0;
    }

    public boolean search(int m) {
        for(int i = 0; i < N; i++) {
            if(checkerboard[m][i] == 0) {

                //在二位数组中把攻击范围和皇后位置加上标识
                for(int j = 0; j < N; j++) {
                    judge(m, j);
                    judge(j, i);
                }
                for(int x = i, y = m; x >=0 && y < N; x--, y++) {
                    judge(y, x);
                }
                for(int x = i, y = m; x < N && y < N; x++, y++) {
                    judge(y, x);
                }
                for(int x = i, y = m; x < N && y >= 0; x++, y--) {
                    judge(y, x);
                }
                for(int x = i, y = m; x >= 0 && y >= 0; x--, y--) {
                    judge(y, x);
                }
                checkerboard[m][i] = -1;

                //当m>=N说明一种情况完成，继续判断下一种情况
                if(++m >= N) {
                    StringBuilder s = new StringBuilder();
                    List<String> tempList = new ArrayList<>();
                    for(int l = 0; l < N; l++) {
                        for(int j = 0; j < N; j++) {
                            if(checkerboard[l][j] == -1) {
                                s.append('Q');
                            } else {
                                s.append('.');
                            }
                        }
                        tempList.add(s.toString());
                        s = new StringBuilder();
                    }
                    result.add(tempList);
                    //把当前位置的皇后标识和攻击范围去除
                    toBack(i, --m);
                    //继续下一格
                    continue;
                }

                //递归往下层走
                if(!search(m)) {
                    //回溯
                    toBack(i, --m);
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public List<List<String>> solveNQueens(int n) {
        N = n;
        checkerboard = new int[n][n];
        search(0);

        return result;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> result = nQueens.solveNQueens(4);
        for(List<String> list : result) {
            list.forEach(System.out::println);
            System.out.println();
        }
    }
}
