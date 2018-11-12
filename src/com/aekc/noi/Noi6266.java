package com.aekc.noi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Noi6266 {

    public static boolean dfs(long n, long m, long k) {
        if(n == m) {
            if(k % 2 == 0) {
                return false;
            }
            return true;
        }
        if(n < m) {
            if(n * 2 <= m) {
                if(k % 2 == 0) {
                    return false;
                }
                return true;
            }
            return dfs(n, m - n, k + 1);
        } else {
            if(m * 2 <= n) {
                if(k % 2 == 0) {
                    return false;
                }
                return true;
            }
            return dfs(n - m, m, k + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while(true) {
            long n = scanner.nextInt();
            long m = scanner.nextInt();
            if(n == 0 && m == 0) {
                break;
            }
            if(dfs(n, m, 1)) {
                list.add("win");
            } else {
                list.add("lose");
            }
        }
        list.forEach(System.out::println);
    }
}
