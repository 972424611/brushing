package com.aekc.noi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Noi2727 {

    private static char[][] coordinate;

    private static int[][] minCoordinate;

    private static int ans = 0;

    // 地图的纵向长度
    private static int n;

    // 地图的横向长度
    private static int m;

    // 仙草的纵坐标
    private static int q;

    // 仙草的横坐标
    private static int p;

    public static void dfs(int i, int j) {
        int step = minCoordinate[i][j];
        if(i == q && j == p) {
            ans = step;
        }
        step++;
        //不超界限&&不是怪物&&更优
        if(i > 0 && coordinate[i - 1][j] != '#' && minCoordinate[i - 1][j] > step) {
            minCoordinate[i - 1][j] = step;
            dfs(i - 1, j);
        }
        if(i < n - 1 && coordinate[i + 1][j] != '#' && minCoordinate[i + 1][j] > step) {
            minCoordinate[i + 1][j] = step;
            dfs(i + 1, j);
        }
        if(j > 0 && coordinate[i][j - 1] != '#' && minCoordinate[i][j - 1] > step) {
            minCoordinate[i][j - 1] = step;
            dfs(i, j - 1);
        }
        if(j < m - 1 && coordinate[i][j + 1] != '#' && minCoordinate[i][j + 1] > step) {
            minCoordinate[i][j + 1] = step;
            dfs(i, j + 1);
        }
    }

    public static class Index {
        public int x;
        public int y;
        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(Index index) {
        LinkedList<Index> queue = new LinkedList<>();
        queue.offer(index);
        while(!queue.isEmpty()) {
            Index temp = queue.poll();
            int i = temp.x;
            int j = temp.y;
            // 如果是障碍物
            if(coordinate[i][j] == '#') {
                continue;
            }
            // 如果是仙草
            if(coordinate[i][j] == '*') {
                ans = minCoordinate[i][j];
                break;
            }
            // 不超过界线 && 没访问过该点
            if(i > 0 && minCoordinate[i - 1][j] == Integer.MAX_VALUE) {
                // 该点对应的minCoordinate的值设置为起点即@的位置到该点的最短距离
                minCoordinate[i - 1][j] = minCoordinate[i][j] + 1;
                queue.offer(new Index(i - 1, j));
            }
            if(i < n - 1 && minCoordinate[i + 1][j] == Integer.MAX_VALUE) {
                minCoordinate[i + 1][j] = minCoordinate[i][j] + 1;
                queue.offer(new Index(i + 1, j));
            }
            if(j > 0 && minCoordinate[i][j - 1] == Integer.MAX_VALUE) {
                minCoordinate[i][j - 1] = minCoordinate[i][j] + 1;
                queue.offer(new Index(i, j - 1));
            }
            if(j < m - 1 && minCoordinate[i][j + 1] == Integer.MAX_VALUE) {
                minCoordinate[i][j + 1] = minCoordinate[i][j] + 1;
                queue.offer(new Index(i, j + 1));
            }
        }
    }

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
                    // 没访问的点都设位置为Integer.MAX_VALUE
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
            // 起点到起点为0
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
