package com.aekc.noi;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Twilight
 * @date 2019-03-08 20:08
 */
public class Noi7218 {

    private static int n;

    private static int m;

    private static char[][] map;

    private static int[][] minStep;

    public static class Index {
        public int x;
        public int y;
        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void dfs(int i, int j) {
        int step = minStep[i][j];
        step++;
        if(i > 0 && map[i - 1][j] != '#' && minStep[i - 1][j] > step) {
            minStep[i - 1][j] = step;
            dfs(i - 1, j);
        }
        if(i < n - 1 && map[i + 1][j] != '#' && minStep[i + 1][j] > step) {
            minStep[i + 1][j] = step;
            dfs(i + 1, j);
        }
        if(j > 0 && map[i][j - 1] != '#' && minStep[i][j - 1] > step) {
            minStep[i][j - 1] = step;
            dfs(i, j - 1);
        }
        if(j < m - 1 && map[i][j + 1] != '#' && minStep[i][j + 1] > step) {
            minStep[i][j + 1] = step;
            dfs(i, j + 1);
        }
    }

    public static boolean bfs(int i, int j)  {
        LinkedList<Index> queue = new LinkedList<>();
        queue.offer(new Index(i, j));
        while(!queue.isEmpty()) {
            Index index = queue.poll();
            j = index.y;
            i = index.x;
            // 如果找到则返回
            if(map[i][j] == 'E') {
                return true;
            }
            // 边界判断、墙壁判断、重复判断
            if(i > 0 && map[i - 1][j] != '#' && minStep[i - 1][j] == 0) {
                minStep[i - 1][j] = minStep[i][j] + 1;
                queue.offer(new Index(i - 1, j));
            }
            if(i < n - 1 && map[i + 1][j] != '#' && minStep[i + 1][j] == 0) {
                minStep[i + 1][j] = minStep[i][j] + 1;
                queue.offer(new Index(i + 1, j));
            }
            if(j > 0 && map[i][j - 1] != '#' && minStep[i][j - 1] == 0) {
                minStep[i][j - 1] = minStep[i][j] + 1;
                queue.offer(new Index(i, j - 1));
            }
            if(j < m - 1 && map[i][j + 1] != '#' && minStep[i][j + 1] == 0) {
                minStep[i][j + 1] = minStep[i][j] + 1;
                queue.offer(new Index(i, j + 1));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            map = new char[n][m];
            minStep = new int[n][m];
            int p = 0, q = 0;
            int x = 0, y = 0;
            for(int i = 0; i < n; i++) {
                String s = scanner.next();
                for(int j = 0; j < m; j++) {
                    map[i][j] = s.charAt(j);
                    //minStep[i][j] = Integer.MAX_VALUE;
                    if(map[i][j] == 'S') {
                        p = i;
                        q = j;
                    } else if(map[i][j] == 'E') {
                        x = i;
                        y = j;
                    }
                }
            }
            if(bfs(p, q)) {
                System.out.println(minStep[x][y]);
            } else {
                System.out.println("oop!");
            }
            /*minStep[p][q] = 0;
            dfs(p, q);
            if(minStep[x][y] == Integer.MAX_VALUE) {
                System.out.println("oop!");
            } else {
                System.out.println(minStep[x][y]);
            }*/

        }
    }
}
