package com.aekc.noi;

import java.util.Scanner;

public class Noi1996 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scenery = new int[n];
        int[] max = new int[n];
        scenery[0] = scanner.nextInt();
        max[0] = 1;
        for(int i = 1; i < n; i++) {
            scenery[i] = scanner.nextInt();
            for(int j = 0; j < i; j++) {
                if(scenery[i] > scenery[j] && max[i] <= max[j]) {
                    max[i] = max[j] + 1;
                }
            }
            if(max[i] == 0) {
                max[i] = 1;
            }
        }
        int[] min = new int[n];
        min[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--) {
            for(int j = n - 1; j > i; j--) {
                if(scenery[i] > scenery[j] && min[i] <= min[j]) {
                    min[i] = min[j] + 1;
                }
            }
            if(min[i] == 0) {
                min[i] = 1;
            }
        }
        int k = 0;
        for(int i = 0; i < n; i++) {
            if((max[i] + min[i]) > k) {
                k = max[i] + min[i];
            }
        }
        System.out.println(k - 1);
    }
}
