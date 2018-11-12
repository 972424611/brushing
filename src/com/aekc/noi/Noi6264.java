package com.aekc.noi;

import java.util.LinkedList;
import java.util.Scanner;

public class Noi6264 {

    private static int[][] minStep;

    private static char[][] map;

    private static int n;

    private static int m;

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
            if(map[i][j] == 'T') {
                break;
            }
            if(map[i][j] == '#') {
                continue;
            }
            if(i > 0 && minStep[i - 1][j] == 0) {
                minStep[i - 1][j] = minStep[i][j] + 1;
                queue.offer(new Index(i - 1, j));
            }
            if(j > 0 && minStep[i][j - 1] == 0) {
                minStep[i][j - 1] = minStep[i][j] + 1;
                queue.offer(new Index(i, j - 1));
            }
            if(i < n - 1 && minStep[i + 1][j] == 0) {
                minStep[i + 1][j] = minStep[i][j] + 1;
                queue.offer(new Index(i + 1, j));
            }
            if(j < m - 1 && minStep[i][j + 1] == 0) {
                minStep[i][j + 1] = minStep[i][j] + 1;
                queue.offer(new Index(i, j + 1));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                if(map[i][j] == 'S') {
                    x = i;
                    y = j;
                } else if(map[i][j] == 'T') {
                    q = i;
                    p = j;
                }
            }
        }
        bfs(x, y);
        System.out.println(minStep[q][p]);

    }
}
