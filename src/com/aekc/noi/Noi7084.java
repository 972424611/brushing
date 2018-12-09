package com.aekc.noi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Noi7084 {

    public static int[][] map = new int[5][5];

    public static class Index {
        public int x;
        public int y;
        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Index[][] bfs(int i, int j) {
        LinkedList<Index> queue = new LinkedList<>();
        queue.add(new Index(i, j));
        Index[][] parent = new Index[5][5];
        boolean[][] isVisit = new boolean[5][5];
        while(!queue.isEmpty()) {
            Index index = queue.poll();
            i = index.x;
            j = index.y;
            if(i == 4 && j == 4) {
                break;
            }
            if(map[i][j] == 1) {
                continue;
            }
            if(i < 4 && !isVisit[i + 1][j]) {
                isVisit[i + 1][j] = true;
                parent[i + 1][j] = index;
                queue.offer(new Index(i + 1, j));
            }
            if(j < 4 && !isVisit[i][j + 1]) {
                isVisit[i][j + 1] = true;
                parent[i][j + 1] = index;
                queue.offer(new Index(i, j + 1));
            }
        }
        return parent;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        Index[][] parent = bfs(0, 0);
        List<String> list = new ArrayList<>();

        int i = 4;
        int j = 4;
        list.add("(" + i + ", " + j + ")");
        while(true) {
            Index index = parent[i][j];
            if (index == null) {
                break;
            }
            list.add("(" + index.x + ", " + index.y + ")");
            i = index.x;
            j = index.y;
        }
        for(int k = list.size() - 1; k >= 0; k--) {
            System.out.println(list.get(k));
        }
    }
}
