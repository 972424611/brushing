package com.aekc.noi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Noi4980 {

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

    public static void bfs(int i, int j) {
        LinkedList<Index> queue = new LinkedList<>();
        queue.offer(new Index(i, j));
        while(!queue.isEmpty()) {
            Index index = queue.poll();
            i = index.x;
            j = index.y;

            if(map[i][j] == '#') {
                continue;
            }
            if(i > 0) {
                int step = map[i - 1][j] == 'x' ? minStep[i][j] + 2 : minStep[i][j] + 1;
                if(minStep[i - 1][j] > step) {
                    minStep[i - 1][j] = step;
                    queue.offer(new Index(i - 1, j));
                }
            }
            if(j > 0) {
                int step = map[i][j - 1] == 'x' ? minStep[i][j] + 2 : minStep[i][j] + 1;
                if(minStep[i][j - 1] > step) {
                    minStep[i][j - 1] = step;
                    queue.offer(new Index(i, j - 1));
                }
            }
            if(i < n - 1) {
                int step = map[i + 1][j] == 'x' ? minStep[i][j] + 2 : minStep[i][j] + 1;
                if(minStep[i + 1][j] > step) {
                    minStep[i + 1][j] = step;
                    queue.offer(new Index(i + 1, j));
                }
            }
            if(j < m - 1) {
                int step = map[i][j + 1] == 'x' ? minStep[i][j] + 2 : minStep[i][j] + 1;
                if(minStep[i][j + 1] > step) {
                    minStep[i][j + 1] = step;
                    queue.offer(new Index(i, j + 1));
                }
            }
        }
    }

/*  //用DFS会超时
    public static void dfs(int i, int j) {
        int step = minStep[i][j];
        step++;
        if(i > 0 && map[i - 1][j] != '#' && minStep[i - 1][j] > step) {
            minStep[i - 1][j] = step;
            if(map[i - 1][j] == 'x') {
                minStep[i - 1][j] = step + 1;
            }
            dfs(i - 1, j);
        }
        if(j > 0 && map[i][j - 1] != '#' && minStep[i][j - 1] > step) {
            minStep[i][j - 1] = step;
            if(map[i][j - 1] == 'x') {
                minStep[i][j - 1] = step + 1;
            }
            dfs(i, j - 1);
        }
        if(i < n - 1 && map[i + 1][j] != '#' && minStep[i + 1][j] > step) {
            minStep[i + 1][j] = step;
            if(map[i + 1][j] == 'x') {
                minStep[i + 1][j] = step + 1;
            }
            dfs(i + 1, j);
        }
        if(j < m - 1 && map[i][j + 1] != '#' && minStep[i][j + 1] > step) {
            minStep[i][j + 1] = step;
            if(map[i][j + 1] == 'x') {
                minStep[i][j + 1] = step + 1;
            }
            dfs(i, j + 1);
        }
    }
*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for(int k = 0; k < s; k++) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            map = new char[n][m];
            minStep = new int[n][m];
            int x = 0, y = 0;
            int q = 0, p = 0;
            for(int i = 0; i < n; i++) {
                String temp = scanner.next();
                for(int j = 0; j < m; j++) {
                    map[i][j] = temp.charAt(j);
                    minStep[i][j] = Integer.MAX_VALUE;
                    if(map[i][j] == 'r') {
                        x = i;
                        y = j;
                    } else if(map[i][j] == 'a') {
                        q = i;
                        p = j;
                    }
                }
            }
            minStep[x][y] = 0;
            bfs(x, y);
            if(minStep[q][p] == Integer.MAX_VALUE) {
                list.add("Impossible");
                //System.out.println("Impossible");
            } else {
                list.add(String.valueOf(minStep[q][p]));
                //System.out.println(minStep[q][p]);
            }
        }
        list.forEach(System.out::println);
    }
}
