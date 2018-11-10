package com.aekc.noi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Noi2727 {

    private static char[][] coordinate;

    private static int[][] minCoordinate;

    private static int ans = 0;

    private static int n;

    private static int m;

    private static int q;

    private static int p;

    public static void dfs(int i, int j) {
        int t = minCoordinate[i][j];
        if(i == q && j == p) {
            ans = t;
        }
        t++;
        //不超界限&&不是怪物&&更优
        if(i > 0 && coordinate[i - 1][j] != '#' && minCoordinate[i - 1][j] > t) {
            minCoordinate[i - 1][j] = t;
            dfs(i - 1, j);
        }
        if(i < n - 1 && coordinate[i + 1][j] != '#' && minCoordinate[i + 1][j] > t) {
            minCoordinate[i + 1][j] = t;
            dfs(i + 1, j);
        }
        if(j > 0 && coordinate[i][j - 1] != '#' && minCoordinate[i][j - 1] > t) {
            minCoordinate[i][j - 1] = t;
            dfs(i, j - 1);
        }
        if(j < m - 1 && coordinate[i][j + 1] != '#' && minCoordinate[i][j + 1] > t) {
            minCoordinate[i][j + 1] = t;
            dfs(i, j + 1);
        }
    }

    private static int sum = 0;

    private static int minSum = 1000000;

    public static class Index {
        public int x;
        public int y;
        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

/*
    public static int bfs(Index index) {
        LinkedList<Index> queue = new LinkedList<>();
        queue.offer(index);
        while(!queue.isEmpty()) {
            Index temp = queue.poll();
            int i = temp.x;
            int j = temp.y;
            sum++;
            if(coordinate[i][j] == '*') {
                if(sum <= minSum) {
                    minSum = sum;
                    sum = 0;
                    continue;
                }
            }

            if(i > 0 && !flag[i - 1][j]) {
                flag[i - 1][j] = true;
                queue.offer(new Index(i - 1, j));
            }
            if(i < n - 1 && !flag[i + 1][j]) {
                flag[i + 1][j] = true;
                queue.offer(new Index(i + 1, j));
            }
            if(j > 0 && !flag[i][j - 1]) {
                flag[i][j - 1] = true;
                queue.offer(new Index(i, j - 1));
            }
            if(j < m - 1 && !flag[i][j + 1]) {
                flag[i][j + 1] = true;
                queue.offer(new Index(i, j + 1));
            }
        }
        return minSum;
    }
*/

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            if(n == 0 && m == 0) {
                break;
            }
            coordinate = new char[n][m];
            minCoordinate = new int[n][m];
            int x = 0, y = 0;
            for(int i = 0; i < n; i++) {
                String temp = scanner.next();
                for(int j = 0; j < m; j++) {
                    coordinate[i][j] = temp.charAt(j);
                    minCoordinate[i][j] = Integer.MAX_VALUE;
                    if(coordinate[i][j] == '@') {
                        x = i;
                        y = j;
                    } else if(coordinate[i][j] == '*') {
                        q = i;
                        p = j;
                    }
                }
            }
            minCoordinate[x][y] = 0;
            dfs(x, y);
            if(ans == 0) {
                list.add(-1);
            } else {
                list.add(ans);
            }
            ans = 0;
        }
        for(Integer i : list) {
            System.out.println(i);
        }
    }
}
