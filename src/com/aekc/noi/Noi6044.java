package com.aekc.noi;

import java.util.LinkedList;
import java.util.Scanner;

public class Noi6044 {

    private static char[][] map;

    private static int[][] minStep;

    private static int[][] ckl;

    private static int m;

    private static int n;

    public static class Index {
        public int x;
        public int y;
        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

//10 10 1
//@#********
//*******###
//*******##*
//*******##*
//*******##*
//*******##*
//*******##*
//*******##*
//*******##*
//*******##+

    public static void bfs(int i, int j) {
        LinkedList<Index> queue = new LinkedList<>();
        queue.offer(new Index(i, j));
        while(!queue.isEmpty()) {
            Index index = queue.poll();
            i = index.x;
            j = index.y;
            if(map[i][j] == '+') {
                break;
            }
            if(i > 0 && ckl[i - 1][j] < ckl[i][j]) {
                if(map[i - 1][j] == '#' && ckl[i][j] > 0) {
                    minStep[i - 1][j] = minStep[i][j] + 1;
                    queue.offer(new Index(i - 1, j));
                    ckl[i - 1][j] = ckl[i][j] - 1;
                } else if(map[i - 1][j] != '#') {
                    minStep[i - 1][j] = minStep[i][j] + 1;
                    queue.offer(new Index(i - 1, j));
                    ckl[i - 1][j] = ckl[i][j];
                }
            }
            if(j > 0 && ckl[i][j - 1] < ckl[i][j]) {
                if(map[i][j - 1] == '#' && ckl[i][j] > 0) {
                    minStep[i][j - 1] = minStep[i][j] + 1;
                    queue.offer(new Index(i, j - 1));
                    ckl[i][j - 1] = ckl[i][j] - 1;
                } else if(map[i][j - 1] != '#') {
                    minStep[i][j - 1] = minStep[i][j] + 1;
                    queue.offer(new Index(i, j - 1));
                    ckl[i][j - 1] = ckl[i][j];
                }
            }
            if(i < m - 1 && ckl[i + 1][j] < ckl[i][j]) {
                if(map[i + 1][j] == '#' && ckl[i][j] > 0) {
                    minStep[i + 1][j] = minStep[i][j] + 1;
                    queue.offer(new Index(i + 1, j));
                    ckl[i + 1][j] = ckl[i][j] - 1;
                } else if(map[i + 1][j] != '#') {
                    minStep[i + 1][j] = minStep[i][j] + 1;
                    queue.offer(new Index(i + 1, j));
                    ckl[i + 1][j] = ckl[i][j];
                }
            }
            if(j < n - 1 && ckl[i][j + 1] < ckl[i][j]) {
                if(map[i][j + 1] == '#' && ckl[i][j] > 0) {
                    minStep[i][j + 1] = minStep[i][j] + 1;
                    queue.offer(new Index(i, j + 1));
                    ckl[i][j + 1] = ckl[i][j] - 1;
                } else if(map[i][j + 1] != '#') {
                    minStep[i][j + 1] = minStep[i][j] + 1;
                    queue.offer(new Index(i, j + 1));
                    ckl[i][j + 1] = ckl[i][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        int k = scanner.nextInt();
        map = new char[m][n];
        minStep = new int[m][n];
        ckl = new int[m][n];
        int x = 0, y = 0;
        int q = 0, p = 0;
        for(int i = 0; i < m; i++) {
            String temp = scanner.next();
            for(int j = 0; j < n; j++) {
                map[i][j] = temp.charAt(j);
                ckl[i][j] = -1;
                if(map[i][j] == '@') {
                    x = i;
                    y = j;
                } else if(map[i][j] == '+') {
                    q = i;
                    p = j;
                }
            }
        }
        ckl[x][y] = k;
        bfs(x, y);
        if(minStep[q][p] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(minStep[q][p]);
        }
    }
}
