package com.aekc.noi;

import java.util.LinkedList;
import java.util.Scanner;

public class Noi2753 {

    private static char[][] map;

    private static int[][] minStepMap;

    private static int step = 0;

    private static int c;

    private static int r;

    public static void dfs(int i, int j) {
        int step = minStepMap[i][j];
        step++;
        if(i > 0 && map[i - 1][j] != '#' && minStepMap[i - 1][j] > step) {
            minStepMap[i - 1][j] = step;
            dfs(i - 1, j);
        }
        if(j > 0 && map[i][j - 1] != '#' && minStepMap[i][j - 1] > step) {
            minStepMap[i][j - 1] = step;
            dfs(i, j - 1);
        }
        if(i < r - 1 && map[i + 1][j] != '#' && minStepMap[i + 1][j] > step) {
            minStepMap[i + 1][j] = step;
            dfs(i + 1, j);
        }
        if(j < c - 1 && map[i][j + 1] != '#' && minStepMap[i][j + 1] > step) {
            minStepMap[i][j + 1] = step;
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
            if(i == r - 1 && j == c - 1) {
                break;
            }
            if(i > 0 && minStepMap[i - 1][j] == Integer.MAX_VALUE) {
                minStepMap[i - 1][j] = minStepMap[i][j] + 1;
                queue.offer(new Index(i - 1, j));
            }
            if(j > 0 && minStepMap[i][j - 1] == Integer.MAX_VALUE) {
                minStepMap[i][j - 1] = minStepMap[i][j] + 1;
                queue.offer(new Index(i, j - 1));
            }
            if(i < r - 1 && minStepMap[i + 1][j] == Integer.MAX_VALUE) {
                minStepMap[i + 1][j] = minStepMap[i][j] + 1;
                queue.offer(new Index(i + 1, j));
            }
            if(j < c - 1 && minStepMap[i][j + 1] == Integer.MAX_VALUE) {
                minStepMap[i][j + 1] = minStepMap[i][j] + 1;
                queue.offer(new Index(i , j + 1));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        r = scanner.nextInt();
        c = scanner.nextInt();
        map = new char[r][c];
        minStepMap = new int[r][c];
        for(int i = 0; i < r; i++) {
            String temp = scanner.next();
            for(int j = 0; j < c; j++) {
                map[i][j] = temp.charAt(j);
                minStepMap[i][j] = Integer.MAX_VALUE;
            }
        }
        minStepMap[0][0] = 0;
        bfs(0, 0);
        System.out.println(1 + minStepMap[r - 1][c - 1]);
    }
}
