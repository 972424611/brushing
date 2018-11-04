package com.aekc.noi;

import java.util.Arrays;
import java.util.Scanner;

public class Noi7617 {

    private static int n;

    private static int m;

    private static int index;

    public static int[] quickSort2(int[] nums) {
        return quickSort2(nums, 0, nums.length - 1);
    }

    public static int[] quickSort2(int[] nums, int p, int r) {
        if(p < r) {
            int q = partition2(nums, p, r);
            if(m == n - q - 1) {
                index = q + 1;
                return nums;
            } else if(m > n - q - 1) {
                m = m - (n - q - 1);
                n = q;
                quickSort2(nums, p, q - 1);
            } else if(m < n - q - 1) {
                quickSort2(nums, q + 1, r);
            }
        }
        return nums;
    }

    public static int partition2(int[] nums, int p, int r) {
        int i = p;
        int j = r + 1;
        while(true) {
            while(nums[++i] < nums[p]);
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
        n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        m = scanner.nextInt();
        nums = quickSort2(nums);
        Arrays.sort(nums, index , nums.length);
        for(int i = nums.length - 1; i >= index; i--) {
            System.out.println(nums[i]);
        }
    }
}
