package com.aekc.noi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Noi1792 {

    private static boolean[][] flag;

    private static char[][] c;

    private static int hb;

    private static int lb;

    public static boolean dfs(int x, int y) {
        flag[x][y] = true;
        if(x == hb && y == lb && c[x][y] != '#') {
            return true;
        }
        if(!flag[x + 1][y]) {
            if(dfs(x + 1, y)) {
                return true;
            }
        }
        if(!flag[x - 1][y]) {
            if(dfs(x - 1, y)) {
                return true;
            }
        }
        if(!flag[x][y + 1]) {
            if(dfs(x, y + 1)) {
                return true;
            }
        }
        if(!flag[x][y - 1]) {
            if(dfs(x, y - 1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < k; i++) {
            int n = scanner.nextInt();
            c = new char[n + 2][n + 2];
            flag = new boolean[n + 2][n + 2];
            for(int q = 0; q < n; q++) {
                String cTemp = scanner.next();
                for(int p = 0; p < n; p++) {
                    c[q + 1][p + 1] = cTemp.charAt(p);
                }
            }
            int ha = scanner.nextInt() + 1;
            int la = scanner.nextInt() + 1;
            hb = scanner.nextInt() + 1;
            lb = scanner.nextInt() + 1;
            for(int q = 0; q < n + 2; q++) {
                for(int p = 0; p < n + 2; p++) {
                    if(c[q][p] == '\0' || c[q][p] == '#') {
                        flag[q][p] = true;
                    }
                }
            }
            if(c[ha][la] == '#') {
                list.add("NO");
                continue;
            }
            if(dfs(ha, la)) {
                list.add("YES");
            } else {
                list.add("NO");
            }
        }
        for(String s : list) {
            System.out.println(s);
        }
    }
}
