package com.aekc.noi;

import java.util.Scanner;

public class Noi3532 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[10001];
        int maxUp = 0;
        for(int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            int max = 0;
            for(int j = 0; j < k; j++) {
                max = Math.max(nums[j], max);
            }
            nums[k] = max + k;
            if(nums[k] > maxUp) {
                maxUp = nums[k];
            }
        }
        System.out.println(maxUp);
    }
}
