package com.aekc.noi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Noi1809 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[100];
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        int k;
        while((k = scanner.nextInt()) != 0) {
            a[k] = 1;
            list.add(k);
        }
        for(Integer i : list) {
            if(i <= 49 && a[i * 2] != 0) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
