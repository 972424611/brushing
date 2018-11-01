package com.aekc.noi;

public class Noi1943 {

    public static void main(String[] args) {
        for(int i = 1; i <= 100; i++) {
            for(int j = i; j <= 100; j++) {
                for(int k = j + 1; k <= 100; k++) {
                    if(Math.pow(i, 2) + Math.pow(j, 2) == Math.pow(k, 2)) {
                        System.out.printf("%d*%d + %d*%d = %d*%d\n", i, i, j, j, k, k);
                    }
                }
            }
        }
    }
}
