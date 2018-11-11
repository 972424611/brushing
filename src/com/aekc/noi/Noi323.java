package com.aekc.noi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Noi323 {

    private static int n;

    private static int k;

    private static int C = 0;

    private static char[][] map;

    private static boolean[] flag;

    public static int dfs(int x, int y) {
        if(y >= k) {
            C++;
            return 0;
        }
        for(int i = x; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!flag[j] && map[i][j] == '#') {
                    flag[j] = true;
                    dfs(i + 1, y + 1);
                    flag[j] = false;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            if(n == -1 && k == -1) {
                break;
            }
            map = new char[n][n];
            flag = new boolean[n];
            for(int i = 0; i < n; i++) {
                String temp = scanner.next();
                for(int j = 0; j < n; j++) {
                    map[i][j] = temp.charAt(j);
                }
            }
            dfs(0, 0);
            list.add(C);
            C = 0;
        }
        list.forEach(System.out::println);
    }
}
