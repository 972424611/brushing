package com.aekc.noi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Noi1792 {

    private static char[][] c;

    private static boolean[][] flag;

    private static int ha;

    private static int la;

    private static int hb;

    private static int lb;

    public static boolean dfs(int x, int y) {
        if(!flag[x + 1][y]) {
            if(x == hb && y == lb) {
                return true;
            }
            if(dfs(x + 1, y)) {
                return true;
            }
        }
        if(!flag[x - 1][y]) {
            if(x == hb && y == lb) {
                return true;
            }
            if(dfs(x - 1, y)) {
                return true;
            }
        }
        if(!flag[x][y + 1]) {
            if(x == hb && y == lb) {
                return true;
            }
            if(dfs(x, y + 1)) {
                return true;
            }
        }
        if(!flag[x][y - 1]) {
            if(x == hb && y == lb) {
                return true;
            }
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
        for(int i = 0; i < k; i++) {
            int n = scanner.nextInt();
            c = new char[n + 2][n + 2];
            flag = new boolean[n + 2][n + 2];
            for(int q = 1; q < n + 1; q++) {
                for(int p = 1; p < n + 1; p++) {
                    String cTemp;
                    while(!" ".equals(cTemp = scanner.next()));
                    c[q][p] = cTemp.charAt(0);
                    if(c[q][p] == '#' || q == 1 || p == 1 || q == n || p == n) {
                        flag[q][p] = true;
                    }
                }
            }
            ha = scanner.nextInt();
            la = scanner.nextInt();
            hb = scanner.nextInt();
            lb = scanner.nextInt();
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
