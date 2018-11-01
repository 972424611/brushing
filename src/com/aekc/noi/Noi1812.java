package com.aekc.noi;

import java.util.Scanner;

public class Noi1812 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 3; i <= n; i++) {
            for(int j = 2; j <= i; j++) {
                for(int k = j; k <= i; k++) {
                    if(Math.pow(i, 3) <= (Math.pow(j, 3) + Math.pow(k, 3))) {
                        continue;
                    }
                    for(int l = k; l <= i; l++) {
                        if(Math.pow(i, 3) == Math.pow(j, 3) + Math.pow(k, 3) + Math.pow(l, 3)) {
                            System.out.println("Cube = " + i + ", Triple = (" + j + "," + k + "," + l + ")");
                        }
                    }
                }
            }
        }
    }
}
