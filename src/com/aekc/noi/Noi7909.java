package com.aekc.noi;

import java.util.Arrays;
import java.util.Scanner;

public class Noi7909 {

    private static int[] nums;

    public static int partition(int p) {
        int i = p;
        int j = nums.length;
        while(true) {
            while(i + 1 < nums.length && nums[++i] < nums[p]);
            while(nums[--j] > nums[p]);
            if(i >= j) break;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        int temp = nums[j];
        nums[j] = nums[p];
        nums[p] = temp;
        return j;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        nums = new int[n];
        int max = 0;
        int k = 0;
        for(int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            if(nums[i] <= 10000 && nums[i] > max) {
                max = nums[i];
                k = i;
            }
        }
        if(n == 1) {
            System.out.println(nums[0] + " " + 1);
            return;
        }
        int temp = nums[0];
        nums[0] = max;
        nums[k] = temp;
        k = partition(0);
        int[] b = new int[10001];
        for(int i = 0; i <= k; i++) {
            b[nums[i]]++;
        }
        for(int i = 0; i < b.length; i++) {
            if(b[i] != 0) {
                System.out.println(i + " " + b[i]);
            }
        }
        if(k != n - 1) {
            Arrays.sort(nums, k + 1, n);
            int sum = 1;
            for(int i = k + 2; i < n; i++) {
                if(nums[i] == nums[i - 1]) {
                    sum++;
                } else {
                    System.out.println(nums[i - 1] + " " + sum);
                    sum = 1;
                }
            }
            System.out.println(nums[n - 1] + " " + sum);
        }

    }
}
