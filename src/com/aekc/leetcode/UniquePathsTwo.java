package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-10-19 下午4:07
 */
public class UniquePathsTwo {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int sum = 0;
        int n = obstacleGrid[0].length;
        int m = obstacleGrid.length;
        if(obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        if(m == 1) {
            for(int i = 0; i < n; i++) {
                if(obstacleGrid[0][i] == 1) {
                    return 0;
                }
            }
            return 1;
        }
        if(n == 1) {
            for(int i = 0; i < m; i++) {
                if(obstacleGrid[i][0] == 1) {
                    return 0;
                }
            }
            return 1;
        }
        if(m == 2) {
            int c = 0;
            for(int i = 0; i < m; i++) {
                if(obstacleGrid[0][i] == 1) {
                    c++;
                    break;
                }
            }
            for(int i = 0; i < m; i++) {
                if(obstacleGrid[1][i] == 1) {
                    c++;
                    break;
                }
            }
            if(c == 2) {
                return 0;
            }
            if(c == 1) {
                return 1;
            }
        }
        for(int i = m - 1; i > 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int k = 0;
                if(i == m - 1 && j == n - 1) {
                    obstacleGrid[m - 1][n - 1] = 1;
                    continue;
                }
                if(obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                if(j > 0 && obstacleGrid[i][j - 1] == 1) {
                    if(obstacleGrid[i - 1][j] == 1) {
                        obstacleGrid[i][j] = 0;
                        continue;
                    }
                }
                if(i < m - 1) {
                    k = k + obstacleGrid[i + 1][j];
                }
                if(j < n - 1) {
                    k = k + obstacleGrid[i][j + 1];
                }
                obstacleGrid[i][j] = k;
            }
        }
        for(int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = -1;
            }
        }
        for(int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == -1) {
                break;
            }
            sum = sum + obstacleGrid[1][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        UniquePathsTwo uniquePathsTwo = new UniquePathsTwo();
        System.out.println(uniquePathsTwo.uniquePathsWithObstacles(new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}
