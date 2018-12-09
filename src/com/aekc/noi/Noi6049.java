package com.aekc.noi;

import java.util.Scanner;

/**
 * @author Twilight
 * @date 18-12-9 下午6:48
 */
public class Noi6049 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] backpack = new int[n + 1];
        int[] bookPrice = new int[5];
        bookPrice[0] = 1;
        bookPrice[1] = 10;
        bookPrice[2] = 20;
        bookPrice[3] = 50;
        bookPrice[4] = 100;
        backpack[0] = 1;
        if(n == 0) {
            System.out.println(0);
            return;
        }
        for(int i = 1; i <= 4; i++) {
            for(int j = bookPrice[i]; j <= n; j++) {
                backpack[j] += backpack[j - bookPrice[i]];
            }
        }
        System.out.println(backpack[n]);
    }
}
