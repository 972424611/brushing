package com.aekc.noi;

import java.math.BigInteger;
import java.util.Scanner;

public class Noi1749 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = n; i >= 0; i--) {
            for(int j = n; j >= 0; j--) {
                if((i + j) % 2 != 0) {
                    continue;
                }
                for(int k = n; k >= 0; k--) {
                    if((k + j) % 3 != 0) {
                        continue;
                    }
                    if((i + j + k) % 5 != 0) {
                        continue;
                    }
                    System.out.println(BigInteger.valueOf(i).add(BigInteger.valueOf(j)).add(BigInteger.valueOf(k)));
                    return;
                }
            }
        }
    }
}
