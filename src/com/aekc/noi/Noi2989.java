package com.aekc.noi;

import java.util.*;

public class Noi2989 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] value = new int[n + 1];
        int total = 0;
        for(int i = 1; i <= n; i++) {
            value[i] = scanner.nextInt();
            total += value[i];
        }
        int[] backpack = new int[total + 1];
         
        int max = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = total; j >= value[i]; j--) {
                backpack[j] = Math.max(backpack[j], backpack[j - value[i]] + value[i]);
                if(backpack[j] % k == 0) {
                    max = Math.max(backpack[j], max);
                }
            }
        }
        System.out.println(max);
    }
}
