package com.aekc.noi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Noi2728 {

    private static int[][] nums;

    private static int[][] maxPeanut;

    private static int r;

    private static int c;

    public static int dp(int x, int y) {
        if(maxPeanut[x][y] != 0) {
            return maxPeanut[x][y];
        }
        if(x == r - 1&& y == c - 1) {
            return nums[x][y];
        }
        if(x == r - 1) {
            return nums[x][y] + dp(x, y + 1);
        }
        if(y == c - 1) {
            return nums[x][y] + dp(x + 1, y);
        }
        maxPeanut[x][y] = nums[x][y] + Math.max(dp(x + 1, y), dp(x, y + 1));
        return maxPeanut[x][y];
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
        maxPeanut[0][0] = nums[0][0];
        while(!queue.isEmpty()) {
            Index index = queue.poll();
            i = index.x;
            j = index.y;
            if(i < r - 1) {
                maxPeanut[i + 1][j] = Math.max(maxPeanut[i + 1][j], nums[i + 1][j] + maxPeanut[i][j]);
                queue.offer(new Index(i + 1, j));
            }
            if(j < c - 1) {
                maxPeanut[i][j + 1] = Math.max(maxPeanut[i][j + 1], nums[i][j + 1] + maxPeanut[i][j]);
                queue.offer(new Index(i, j + 1));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        List<Integer> list = new ArrayList<>(t);
        while(t-- > 0) {
            r = scanner.nextInt();
            c = scanner.nextInt();
            nums = new int[r][c];
            maxPeanut = new int[r][c];
            for(int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++) {
                    nums[i][j] = scanner.nextInt();
                }
            }
            bfs(0, 0);
            list.add(maxPeanut[r - 1][c - 1]);
        }
        list.forEach(System.out::println);
    }
}
