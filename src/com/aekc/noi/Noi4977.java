package com.aekc.noi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Noi4977 {

    static class MaxStep {
        public int maxLeftStep = 0;

        public int maxRightStep = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        while(k-- > 0) {
            int n = scanner.nextInt();
            MaxStep[] nums = new MaxStep[10001];
            int maxLeftStep = 0;
            int maxRightStep = 0;
            int index = 0;
            for(int i = 0; i < n; i++) {
                int p = scanner.nextInt();
                if(nums[p] == null) {
                    nums[p] = new MaxStep();
                }
                int maxLeft = 0;
                int maxRight = 0;
                index = Math.max(index, p);
                for(int j = index; j > p; j--) {
                    if(nums[j] == null) {
                        continue;
                    }
                    maxLeft = Math.max(maxLeft, nums[j].maxLeftStep);
                }
                for(int j = 0; j < p; j++) {
                    if(nums[j] == null) {
                        continue;
                    }
                    maxRight = Math.max(maxRight, nums[j].maxRightStep);
                }
                nums[p].maxLeftStep = 1 + maxLeft;
                nums[p].maxRightStep = 1 + maxRight;
                maxLeftStep = Math.max(nums[p].maxLeftStep, maxLeftStep);
                maxRightStep = Math.max(nums[p].maxRightStep, maxRightStep);
            }
            list.add(Math.max(maxLeftStep, maxRightStep));
        }
        list.forEach(System.out::println);
    }
}
