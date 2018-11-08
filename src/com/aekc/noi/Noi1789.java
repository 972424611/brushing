package com.aekc.noi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Noi1789 {

    private static double[] nums;

    public static boolean specialCalculation(double[] nums) {

        return false;
    }

    public static boolean calculation(double sum, int i) {
        boolean flag;
        if(i == 4) {
            return Math.abs(sum - 24.0) <= 0.0001;
        }

        flag = calculation(sum + nums[i], i + 1);

        if(!flag) {
            flag = calculation(sum - nums[i], i + 1);
        }
        if(!flag) {
            flag = calculation(sum * nums[i], i + 1);
        }
        if(!flag && nums[i] != 0) {
            flag = calculation(sum / nums[i], i + 1);
        }
        return flag;
    }

    public static boolean dfs(int start, double[] numsTemp) {
        for(int i = start; i < 4; i++) {
            if(dfs(start + 1, numsTemp)) {
                return true;
            }
            double temp = numsTemp[start];
            numsTemp[start] = numsTemp[i];
            numsTemp[i] = temp;
            nums = numsTemp;
            if(calculation(0, 0)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<double[]> list = new ArrayList<>();
        while(true) {
            double[] temp = new double[4];
            boolean bb = false;
            for(int i = 0; i < 4; i++) {
                temp[i] = scanner.nextDouble();
                if(temp[i] != 0) {
                    bb = true;
                }
            }
            if(!bb) {
                break;
            }
            list.add(temp);
        }

        for(double[] array : list) {
            if(specialCalculation(array)) {
                System.out.println("YES");
                return;
            }
            if(dfs(0, array)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
