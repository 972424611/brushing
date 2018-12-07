package com.aekc.noi;

import java.util.Scanner;

public class Noi8462 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0) {
            int n = scanner.nextInt();
            int[] backpack = new int[n + 1];
            int[] shop = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                shop[i] = scanner.nextInt();
                backpack[1] = shop[1];
            }
            for(int i = 2; i <= n; i++) {
                backpack[i] = Math.max(backpack[i - 1], backpack[i - 2] + shop[i]);
            }
            System.out.println(backpack[n]);
        }
    }
}