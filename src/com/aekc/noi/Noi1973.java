package com.aekc.noi;

import java.util.Scanner;

public class Noi1973 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        int r = scanner.nextInt();
        int max = 0;
        String s = String.valueOf(p) + q + r;
        for(int i = 0; i < s.length(); i++) {
            if(Integer.valueOf(s.charAt(i) + "") > max) {
                max = Integer.valueOf(s.charAt(i) + "");
            }
        }
        for(int i = max + 1; i <= 16; i++) {
            Integer x = Integer.parseInt(String.valueOf(p), i);
            Integer y = Integer.parseInt(String.valueOf(q), i);
            Integer z = Integer.parseInt(String.valueOf(r), i);
            if(x * y == z) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
