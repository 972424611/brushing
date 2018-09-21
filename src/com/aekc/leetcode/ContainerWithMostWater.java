package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-9-20 下午9:34
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int sum = 0;
        for(int i = 0; i < height.length ; i++) {
            for(int j = i + 1; j < height.length; j++) {
                int k = j - i;
                int a = height[i] > height[j] ? height[j] : height[i];
                int b = a * k;
                if(sum < b) {
                    sum = b;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int k = containerWithMostWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(k);
    }
}
