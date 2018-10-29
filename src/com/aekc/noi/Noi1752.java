package com.aekc.noi;

import java.util.Scanner;

public class Noi1752 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double min = a / 4.0 + (a % 4.0) / 2.0;
        double max = a / 2.0;
        if(min != (int) min || max != (int) max) {
            System.out.println(0 + " " + 0);
        } else {
            System.out.println((int) min + " " + (int) max);
        }

    }
}
