package com.aekc.noi;

import java.util.Scanner;

public class Noi1759 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n == 0) {
            System.out.println(0);
            return;
        }
        int[] nums = new int[n];
        int[] sum = new int[n];
        sum[0] = 1;
        nums[0] = scanner.nextInt();
        int max = 1;
        for(int i = 1; i < n; i++) {
            nums[i] = scanner.nextInt();
            if(nums[i] > nums[i - 1]) {
                sum[i] = sum[i - 1] + 1;
            } else if(nums[i] < nums[i - 1]) {
                sum[i] = 1;
                for(int j = i - 2; j >= 0; j--) {
                    if(nums[j] < nums[i]) {
                        sum[i] = sum[j] + 1;
                        break;
                    } else if(nums[j] == nums[i]) {
                        sum[i] = sum[j];
                        break;
                    }
                }
            } else {
                sum[i] = sum[i - 1];
            }
            if(sum[i] > max) {
                max = sum[i];
            }
        }
        System.out.println(max);
    }
}
