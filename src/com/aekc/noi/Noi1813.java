package com.aekc.noi;

import java.util.Scanner;

public class Noi1813 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] a = new int[7][8];
        for(int i = 1; i < 6; i++) {
            for(int j = 1; j < 7; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        for(int i = 1; i < 6; i++) {
            for(int j = 1; j < 7; j++) {
                if(a[i][j] == 1 || a[i - 1][j] == 1 || a[i + 1][j] == 1 || a[i][j - 1] == 1 || a[i][j + 1] == 1) {
                    a[i][j] = a[i][j] == 0 ? 1 : 0;
                    a[i + 1][j] = a[i + 1][j] == 0 ? 1 : 0;
                    a[i - 1][j] = a[i - 1][j] == 0 ? 1 : 0;
                    a[i][j - 1] = a[i][j - 1] == 0 ? 1 : 0;
                    a[i][j + 1] = a[i][j + 1] == 0 ? 1 : 0;
                }
            }
        }
    }
}
